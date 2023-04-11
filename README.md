# p42_Corregida
P4.2.- Tarjetas de crédito 

En un nuevo proyecto, llamado p42+tunombre, implementa una clase que permita crear objetos de tipo TarjetaCredito. Estas tarjetas regalo se podrían usar en aplicaciones de tipo HelloPay, ya que una vez han agotado su límite de crédito quedan inservibles. Esta clase estará dentro del paquete daw.tunombre.
![image](https://user-images.githubusercontent.com/73947304/231078233-e1fa6184-aa72-471c-b319-7ed3d863f0f8.png)

Aclaraciones respecto a los atributos de las tarjetas de la imagen anterior:
El número de tarjeta debe tener exactamente 16 caracteres numéricos. 
Usa la clase YearMonth del paquete java.time para almacenar el atributo fecha de caducidad de la tarjeta.
Todas las tarjetas deben tener un atributo que indique el límite máximo de crédito que ofrece la tarjeta. Este valor debe estar entre 500€ y 3000€.
Los únicos atributos que permiten el cambio de valor de una tarjeta son: estado (activa/anulada), el pin de seguridad del usuario (el que piden los datáfonos al pagar) y el límite de crédito. 
Si consideras necesario añadir atributos adicionales debes justificar en el código la utilidad de los mismos usando comentarios.
Aplica el principio de encapsulamiento estudiado en clase.

Aclaraciones respecto a los métodos:
Crea un método privado de clase para comprobar si un String tiene 16 caracteres numéricos. Este método debe recorrer el String que recibe como parámetro, obtener cada char y usar la clase envolvente Character para saber si ese char es un dígito. 
Se deben poder crear objetos de tipo TarjetaCredito con un constructor por defecto que establezca los valores según tu criterio, teniendo en cuenta que todas las tarjetas se crean sin activar (anuladas), para poder operar con ellas hay que activarlas (como en la vida real). Una tarjeta puede estar activa o anulada.
También existirá un constructor parametrizado que cumpla las restricciones establecidas. En caso de no cumplir alguna de las restricciones en alguno de los atributos, el constructor establecerá el valor de todos los atributos según los valores establecidos en el constructor por defecto. Estas tarjetas también se crean inactivas.
A la hora de pagar, se debe solicitar por teclado el pin de seguridad de la tarjeta y la cantidad a pagar. En caso de que la tarjeta esté activada, tenga saldo suficiente, no esté caducada y el pin sea coincidente, se realiza la operación y se informa por consola. En caso contrario, se muestra un mensaje indicando el porqué no ha sido posible realizar la operación.
Incluye un método toString que devuelve la información de la tarjeta según el siguiente formato:
	[TABULADOR] Nombre titular [TABULADOR] Banco Emisor
	[TABULADOR] mes/año caducidad [TABULADOR] Crédito
	[TABULADOR] Número de tarjeta
Crea un método de clase, llamado copiar, que reciba un objeto de tipo TarjetaCredito a copiar y devuelva un nuevo objeto con la copia del mismo.

Crea una clase con el método main(). Realiza las siguientes operaciones:

Crea una tarjeta con el constructor por defecto (t1) y otra con el constructor parametrizado (t2).
Crea una copia de t2 en t3.
Muestra los datos de los tres objetos usando la consola y toString.
Anula t2 e intenta pagar cualquier cantidad.
Activa t2 e intenta pagar una cantidad de dinero superior al límite.
Paga con t3 una cantidad de dinero inferior al límite.
Muestra por consola la información de t3.
