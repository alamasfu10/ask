Crea una carpeta que será tu repositorio local de trabajo:
 - Por ejemplo: .../jlallana/MisDocumentos/ask

Desde un cliente de git (terminal, con git instalado) ejecuta
	- git init

Configura git:

	- git config --global user.name "Tu nombre de usuario"
	- git config --global user.email "Tu email de github"

Clona el contenido del repositorio en el directorio en el que has ejecutado git init

	- git clone https://github.com/alamasfu10/ask

Esto debería bajarte el contenido del repositorio a tu PC (Si no, hay algun paso tonto que nos estamos olvidando)

El procedimiento para cuando modifiques código en local y lo quieras subir es:
 - git pull origin master (baja la última versión de github, puede que sea una posterior a la tuya si yo he modificado algo y lo he subido)
 - git commit -m "Mensaje para aclarar qué cambios introduces en esta versión (por si hay que revisarlos o volver atrás)"
 - git push origin master (sube tus cambios al repositorio de github)
 

