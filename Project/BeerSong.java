public class BeerSong {
	public static void main (String[] args){
	int beerNum = 99;
	String word = "бутылок (бутылки)";

	while (beerNum > 0) {
		
			word = "бутылка"; // В единственном числе - ОДНА бутылка.

		
			System.out.println(beerNum + " " + word + "пива на столе");
		System.out.println(beerNum + " " + word + "пива.");
		System.out.println("Возьми одну");
		System.out.println("Пусти по кругу.");
		beerNum = beerNum - 1;
		if (beerNum > 0) {
			System.out.println(beerNum + " " + word + "пива на столе");

		}	else	{
			System.out.println("Нет бутылок пива на столе");

		} // Конец else
	} // Конец цикла while
	} // Конец метода main
} // Конец класса 