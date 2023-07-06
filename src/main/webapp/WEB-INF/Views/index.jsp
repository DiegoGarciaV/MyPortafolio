<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Diego Garcia Vazquez
    </title>


    <link rel="stylesheet" type="text/css" href="css/bootstrap/bootstrap.css">

    <script type="text/javascript" src="js/tools/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="js/tools/angular.js"></script>
    <script type="text/javascript" src="js/tools/angular-route.js"></script>
    <script type="text/javascript" src="js/bootstrap/bootstrap.js"></script>

    <script type="text/javascript" src="js/index.js"></script>
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Montserrat&family=Oswald:wght@300&family=Quicksand&display=swap"
        rel="stylesheet">
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-lg ">

            <div class="collapse navbar-collapse" id="navigator">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Inicio</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#habilities">Sobre mi</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#tenologies">Skils tecnicos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#experience">Mi experiencia</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contacto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">ES <img class="lang-ico" src="img/ES.png" alt="languaje"></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="page-container" id="intro">
        <div id="intro-content-layer">
            <div id="intro-content">
                <h1>Diego Garcia Vazquez</h1>
                <p>Matemático y Desarrollador Full Stack</p>
                <p>Soluciones tecnológicas a la medida, la herramienta
                    perfecta para el negocio perfecto.</p>
            </div>
        </div>

    </div>
    <div class="page-container" id="habilities">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-4">
                    <div id="habilities-carrousel" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active" data-bs-interval="2000"><img src="img/webDev.png"
                                    class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item" data-bs-interval="2000"><img src="img/api.png"
                                    class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item" data-bs-interval="2000"><img src="img/BD.png"
                                    class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item" data-bs-interval="2000"><img src="img/algoritmo.png"
                                    class="d-block w-100" alt="...">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <h3>
                        Desarrollador de Software profesional
                    </h3>
                    <p>
                        Con +5 años de experiencia, ofrezco soluciones de calidad y a
                        la medida para las diferentes necesidades que tu negocio pueda tener.
                    </p>
                    <p>
                        Construcción punta a punta de aplicaciones web que integran servicios
                        eficientes con las tecnologías mas recientes disponibles en el mercado.
                    </p>

                    <ul>
                        <li>Administración de dominio, certificados y alojamiento</li>
                        <li>Diseño de interfaz de usuario</li>
                        <li>Construcción de servicios con base en lógica de negocio</li>
                        <li>Administración de Bases de datos</li>
                        <li>Desarrollo y consumo de APIs </li>


                    </ul>

                    <p>
                        Aplicacion de algorítmos de inteligencia artificial (IA)
                        para resolver problemas de alta complejidad.
                    </p>
                    <ul>
                        <li>Redes neuronales (Deep Learning)</li>
                        <li>Redes neuronales convolucionales</li>
                        <li>Clustering</li>
                        <li>Algoritmos de busqueda heuristicos</li>
                    </ul>

                </div>
            </div>
        </div>
        <div class="container mt-5" id="ejemplos-botones">
            <div class="row justify-content-between">
                <div class="col-3">
                    <button class="btn btn-1">
                        Ejemplo de Herramientas
                    </button>
                </div>
                <div class="col-3">
                    <button class="btn btn-2">
                        Ejemplo de APIs
                    </button>
                </div>
                <div class="col-3">
                    <button class="btn btn-3">
                        Ejemplos de IA
                    </button>
                </div>
            </div>

        </div>
    </div>
    <div class="page-container" id="tenologies">
        <h2>
            Habilidades técnicas
        </h2>
        <div class="container" id="ejemplos">
            <div class="row justify-content-between">
                <div class="col-3">
                    <h3>Back-End</h3>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseJava">Java</p>
                        <ul class="collapse" id="collapseJava">
                            <li>Desarrollo de aplicaciones de escritorio y aplicaciones Web</li>
                            <li>Manejo de Spring (MVC,REST,Batch)</li>
                            <li>JDBC</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseCC">C/C++</p>
                        <ul class="collapse" id="collapseCC">
                            <li>Desarrollo de aplicaciones de alto rendimiento con C y C++</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseNet">.Net</p>
                        <ul class="collapse" id="collapseNet">
                            <li>Desarrollo de aplicaciones de escritorio y aplicaciones Web con C# y VB</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapsePy">Python</p>
                        <ul class="collapse" id="collapsePy">
                            <li>Desarrollo de scripts para estimación paramétrica (Estadística)</li>
                            <li>Desarrollo de Redes neuronales (Python puro, PyTorch, TensowFlow)</li>
                            <li>Desarrollo de Redes neuronales Convolucionales (PyTorch)</li>
                            <li>Desarrollo de aproximaciones con metodos numéricos</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseSQL">SQL</p>
                        <ul class="collapse" id="collapseSQL">
                            <li>Manejo de bases de datos MySQL, SQL Server, Oracle, Cloudera</li>
                            <li>Operaciones DML</li>
                            <li>Procedimientos almacenados, Triggers, Jobs</li>
                        </ul>
                    </div>


                </div>
                <div class="col-3">
                    <h3>APIs</h3>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseAPISpring">Spring Rest
                        </p>
                        <ul class="collapse" id="collapseAPISpring">
                            <li>Desarrollo de APIs Rest basado en Spring Rest</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseAPIJSON">JSON</p>
                        <ul class="collapse" id="collapseAPIJSON">
                            <li>Manejo de formato JSON para intercambio de datos entre APIs</li>
                            <li>Manejo de JSON Web Token</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseAPIOAuth">OAuth 2.0</p>
                        <ul class="collapse" id="collapseAPIOAuth">
                            <li>APIs seguras con servicio de autenticación OAuth 2.0</li>
                        </ul>
                    </div>



                </div>
                <div class="col-3">
                    <h3>Front-End</h3>
                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseHTML">HTML 5</p>
                        <ul class="collapse" id="collapseHTML">
                            <li>Construcción de sitios con HTML 5.0</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseCSS">CSS 3</p>
                        <ul class="collapse" id="collapseCSS">
                            <li>Diseños y estilos responsivos con CSS 3</li>
                            <li>Bootstrap 5.0</li>
                        </ul>
                    </div>

                    <div class="tech-cont">
                        <p class="tech-title" data-bs-toggle="collapse" data-bs-target="#collapseJS">Javascript</p>
                        <ul class="collapse" id="collapseJS">
                            <li>Aplicaciones web dinamicas con javascript</li>
                            <li>Manejo asíncrono de eventos</li>
                            <li>Peteciones asíncronas</li>
                            <li>JQuery</li>
                            <li>AngularJS</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="page-container" id="experience">
        <h2>
            Mi experiencia profesional
        </h2>
        <div id="xp-carrousel" class="carousel slide d-block w-100" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#xp-carrousel" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#xp-carrousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#xp-carrousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#xp-carrousel" data-bs-slide-to="3" aria-label="Slide 4"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item  active">
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <h3>+2 Años MAJD Environmental Consultant<br>Desarrollo web Java</h3>
                                <p>Aplicación web cuya funcionalidad es administrar de manera automática
                                    y eficiente los procesos del negocio.
                                </p>
                                <ul>
                                    <li>HTML, CSS, Javascript, JQuery, AngularJS, Bootstrap</li>
                                    <li>Java Servlet, Java JSP, MySQL, Glassfish</li>
                                    <li>Conexión a base de datos MySQL (JDBC)</li>
                                    <li>Visualización dinámica y en tiempo real de datos</li>
                                    <li>Diseño responsivo</li>
                                    <li>Manejo de API de Google Maps</li>
                                    <li>Generación y consulta de documentación</li>
                                    
                                </ul>
                            </div>
                            <div class="col-6">

                            </div>
                        </div>
                    </div>
                    
                </div>

                <div class="carousel-item">
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <h3>2 Años Grupo Financiero Santander <br> Analista de datos SAS</h3>
                                <p>Analista de datos con la finalidad de calcular y estimar compensación variable 
                                    utilizando lenguaje de programación SAS y SQL.</p>
                                <ul>
                                    <li>SAS Enterprise Guide 5.2</li>
                                    <li>Scripts de calculo de compensación variable (Data Processing)</li>
                                    <li>Scripts de estimación de compensación variable (Data Analytics)</li>
                                    <li>Scripts de limpieza y filtrado de información</li>
                                </ul>
                            </div>
                            <div class="col-6">

                            </div>
                        </div>
                    </div>
                    
                </div>

                <div class="carousel-item">
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <h3>1 Año Grupo Salinas, Banco Azteca<br> Desarrollador de Bases de Datos</h3>
                                <p>Desarrollador de Querys SQL para la carga, consulta y actualización de registros
                                    dentro de las bases de datos de la contabilidad de productos de crédito.
                                </p>
                                <ul>
                                    <li>Configuración de registros de parametría</li>
                                    <li>Extracción y modificación de registros contables para su correcta inserción,
                                        derivado de fallos en el proceso batch por motivos de migración
                                    </li>
                                    <li>Supervisión de ejecucíon de procesos en Control-M</li>
                                </ul>
                            </div>
                            <div class="col-6">

                            </div>
                        </div>
                    </div>
                    
                </div>

                <div class="carousel-item">
                    <div class="container">
                        <div class="row">
                            <div class="col-6">
                                <h3>BBVA<br> Desarrollador Java</h3>
                                <p>Desarrollador de sistemas Back-End con Java.</p>
                                <ul>
                                    <li>Desarrollo de transacciones con tecnología RestTemplate</li>
                                    <li>Desarrollo de procesos Batch con tecnología Spring Batch</li>
                                    <li>Desarrollo de APIs Rest con tecnología Spring Boot</li>
                                </ul>
                            </div>
                            <div class="col-6">

                            </div>
                        </div>
                    </div>
                    
                </div>
                
            </div>

            <button class="carousel-control-prev" type="button" data-bs-target="#xp-carrousel"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#xp-carrousel"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>

        </div>

    </div>

    <div class="page-container" id="contact">
        <h2>
            Cómo encontrarme
        </h2>

    </div>

</body>

</html>