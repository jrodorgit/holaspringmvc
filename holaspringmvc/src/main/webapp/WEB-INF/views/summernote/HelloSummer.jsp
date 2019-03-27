<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Summernote</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote.js"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">
			<h1>Quiero generar un pdf con este texto!</h1>
		</div>
	</div>
	<form action="generarPDFWithSummerNote" method="POST"
		onsubmit="postForm()">

		<div id="summernote">
			<p class="MsoNormal" align="center" style="text-align:center">Registro de Sociedades Cooperativas<br></p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align: left;">NOMBRE_CARGO, CARGO&nbsp;</p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align: left;"><b>CERTIFICO</b>:</p><p class="MsoNormal" align="center" style="text-align: left; margin-left: 75px;">Que conforme a los datos obrantes en este registro de sociedades cooperativas, no figura inscrita una entidad con la denominación.</p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align:center">DENOMINACION</p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align: justify; margin-left: 75px;">La presente certificación queda reservada a favor del solicitante D/Dª SOLICITANTE durante un período de PERIDO_RESERVA meses, a contar desde el día de la fecha.</p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align: justify; margin-left: 75px;">Y para que conste, a los efectos previstos en la Ley 27/1999, de 16 de julio, de cooperativas y en el R.D. 136/2002, de 1 de febrero, del reglamento del registro de sociedades cooperativas, a petición de parte interesa, expido el presente en Madrid a, FECHA.</p><p class="MsoNormal" align="center" style="text-align: justify; margin-left: 75px;"><br></p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align:center"><br></p><p class="MsoNormal" align="center" style="text-align:center">NUMERO LOCALIZADOR RESERVA: NUMERO_LOCALIZADOR.</p>
		</div>
		<script>
			$(document).ready(function() {
				$('#summernote').summernote();
			});
			var EventData = function (context) {
		        var ui = $.summernote.ui;

		        // create button
		        var event = ui.buttonGroup([
		            ui.button({
		                contents: 'Textos Dinamicos <i class="fa fa-caret-down" aria-hidden="true"></i>',
		                tooltip: 'Insertar Textos Dinamicos',
		                data: {
		                    toggle: 'dropdown'
		                }
		            }),
		            ui.dropdown({
		                items: [
		                    'Fulanito Gimenez Perez', 'S. COOPER BEBE Y DEJA BEBER'
		                ],
		                callback: function (items) {
		                    $(items).find('li a').on('click', function(){
		                        context.invoke("editor.insertText", $(this).html())
		                    })
		                }
		            })
		        ]);

		        return event.render();   // return button as jquery object
		    }
		    
			var HelloButton = function(context) {
				var ui = $.summernote.ui;

				// create button
				var button = ui.button({
					contents : '<i class="fa fa-child"/> Sub-Director',
					tooltip : 'Introducir Nombre del Subdirector MTIN',
					click : function() {
						// invoke insertText method with 'hello' on editor module.
						context.invoke('editor.insertText', 'Federico Perez Jimenez');
					}
				});

				return button.render(); // return button as jquery object
			}
			var HelloButtonBis = function(context) {
				var ui = $.summernote.ui;

				// create button
				var button = ui.button({
					contents : '<i class="fa fa-child"/> Presidente',
					tooltip : 'Introducir Nombre Presidente Cooperativa',
					click : function() {
						// invoke insertText method with 'hello' on editor module.
						context.invoke('editor.insertText', 'Eufemio Dios');
					}
				});

				return button.render(); // return button as jquery object
			}
			
			$('#summernote').summernote(
					{
						toolbar : [
								// [groupName, [list of button]]
								['style',[ 'bold', 'italic', 'underline','clear' ] ],
								[ 'fontsize', [ 'fontsize' ] ],
								[ 'para', [ 'ul', 'paragraph' ] ] ,
								['mybutton', ['eventData']],
								['mybuttonBis', ['hello','helloBis']]   
						],
						buttons: {
							eventData:EventData,
						    hello: HelloButton,
						    helloBis: HelloButtonBis
						}
						
					});

			
		</script>
		<input type="hidden" name="textoSM" id="textoSM" value=""> <input
			type="submit" value="Submit">
		<sec:csrfInput />
	</form>
	<script type="text/javascript">
		var postForm = function() {
			//var content = $('div[name="summernote"]').html($('#summernote').code());
			alert($('#summernote').summernote('code'));
			document.getElementById("textoSM").value = $('#summernote')
					.summernote('code');
		}
	</script>
</body>
</html>