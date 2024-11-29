package com.rsfrancisco.mercadolivro.classes.validations

import com.rsfrancisco.mercadolivro.services.BookService
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [ActiveBooksValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ValidateActiveBooks (
    val message: String = "The following books are not active: {invalidBooks}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)


class ActiveBooksValidator (private var bookService: BookService): ConstraintValidator<ValidateActiveBooks, Set<Int>> {
    override fun isValid(bookIds: Set<Int>?, context: ConstraintValidatorContext?): Boolean {
        if (bookIds.isNullOrEmpty()) return false

        val invalidBooks = bookService.getInactiveBookIds(bookIds)
        return if (invalidBooks.isEmpty()) {
            true
        } else {
            var ids = invalidBooks.map { it.id }.toList()
            context!!.disableDefaultConstraintViolation()
            context!!.buildConstraintViolationWithTemplate("The following books are not active: $ids").addConstraintViolation()
            false
        }
    }
}