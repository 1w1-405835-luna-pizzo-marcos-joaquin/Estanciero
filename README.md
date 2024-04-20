# tpi-estanciero-2w1-g2

![Diagrama-de-clases-recortado](https://github.com/LCIII-2023/tpi-estanciero-2w1-g2/assets/142423545/cbdba310-3e86-4e84-a735-81c18bfb5821)

###  Clase Tablero: 

> En la clase Tablero se van a encontrar los jugadores, y se va a encargar de dar inicio a la partida, desarrollar el juego y darle fin. Estará relacionada con las clases Jugador, Modo de Juego y Dificultad
### Clase Jugador: 

> En esta clase vamos a guardar los datos de cada jugador, como su casilla, las propiedades que poseen, los últimos números de dados que salieron, etc. Realizará las acciones de moverse, tirar dados, comprar y vender.

### Clase Casilla: 

>Esta clase va a contener la información como el número de casilla, el tipo de casilla (si se puede comprar o no), y la zona a la que pertenece. A su vez, la clase Zona va a contar con un ID de provincia, ya que tres zonas pueden pertenecer a la misma provincia.

### Clase Propiedades: 

>En esta se van a encontrar cosas como el propietario dueño de la propiedad en caso de tener uno, el número de casilla donde se encuentra, su precio de compra, el de alquiler en caso de tener propietario y su precio con mejoras en caso de tener alguna casa.

### Clase Tarjeta:

> Va a estar la clase para las tarjetas de suerte y la clase para las tarjetas de destino, y en la clase Tarjeta se va a colocar el ID dependiendo del tipo de tarjeta que sea (suerte o destino).