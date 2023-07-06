<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Algorítmos de busqueda
    </title>


    <link rel="stylesheet" type="text/css" href="/css/bootstrap/bootstrap.css">

    <script type="text/javascript" src="/js/tools/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="/js/tools/angular.js"></script>
    <script type="text/javascript" src="/js/tools/angular-route.js"></script>
    <script type="text/javascript" src="/js/bootstrap/bootstrap.js"></script>

    <script type="text/javascript" src="/js/modulos/IA/search/app.js"></script>
    <script type="text/javascript" src="/js/modulos/IA/search/index.js"></script>
    <link rel="stylesheet" href="/css//modulos/IA/search.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Montserrat&family=Oswald:wght@300&family=Quicksand&display=swap"
        rel="stylesheet">
</head>

<body>
    <header>
      <nav>
        <ul>
          <li><a href="#" class="active">Laberinto</a></li>
          <li><a href="#">8-Puzzle</a></li>
          <li><a href="#">Gato</a></li>
          <li><a href="#">Palabras</a></li>
        </ul>
      </nav>
    </header>
  
    <main>
      <section id="game-container">
        <!-- Contenido del juego seleccionado -->
      </section>
  
      <aside>
        <h2>Opciones de Juego</h2>
        <div id="algorithm-options">
          <label>
            <input type="radio" name="algorithm" value="bfs" checked>
            BFS
          </label>
          <label>
            <input type="radio" name="algorithm" value="dfs">
            DFS
          </label>
          <label>
            <input type="radio" name="algorithm" value="ucs">
            UCS
          </label>
          <label>
            <input type="radio" name="algorithm" value="minimax">
            Minimax
          </label>
        </div>
      </aside>
    </main>
  
    <footer>
      <div id="messages">
        <!-- Mensajes y retroalimentación -->
      </div>
    </footer>

  </body>
</html>