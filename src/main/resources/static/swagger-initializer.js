window.onload = function() {
  const ui = SwaggerUIBundle({
    url: "/v3/api-docs",
    dom_id: '#swagger-ui',
    deepLinking: true,
    presets: [
      SwaggerUIBundle.presets.apis,
      SwaggerUIBundle.presets.deepLinking
    ],
    plugins: [
      SwaggerUIBundle.plugins.DownloadUrl
    ],
    layout: "BaseLayout",
    onComplete: function() {
      const servers = document.querySelectorAll('.servers select');
      servers.forEach(server => {
        const options = server.querySelectorAll('option');
        options.forEach(option => {
            if (option.value === 'http://localhost:8080') {
                option.innerText = 'Desenvolvimento'; // Nome que você quer
            }
        });
      });
    }
  });
};
