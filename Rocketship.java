package rocket;

public class RocketShipWork {

	public static void main(String[] args) {
		Blastoff(10);
	}
	public static void Blastoff(int size) {
		int sizefix = size*2-1;
		Section1(sizefix);
		Divider(sizefix);
		Section2a(size);
		Section2b(size);
		Divider(sizefix);
		Section2b(size);
		Section2a(size);
		Divider(sizefix);
		Section1(sizefix);
	}
	public static void Section1(int size){
		for(int i=0; i<size; i++){
			for(int space=size;space>i;space--){
				System.out.print(" ");
		    }for(int frontslash=0; frontslash<=i; frontslash ++) {
				System.out.print("/");
			}for(int stars=0; stars<2; stars++) {
				System.out.print("*");
			}for(int frontslash=0; frontslash<=i; frontslash ++) {
				System.out.print("\\");
			}for(int space=5;space>i;space--){
				System.out.print(" ");
			}
			System.out.println();
			}}
	public static void Section2a(int size) {
		for(int j=0; j<size;j++) {
			for(int bar=0;bar<1;bar++){
				System.out.print("|");
			}for(int dot =size-1;dot>j; dot--) {
				System.out.print("•");
			}for(int slashes=0;slashes<=j;slashes++) {
				System.out.print("/\\");
			}for(int dots =size-1;dots>j; dots--) {
				System.out.print("••");
		    }for(int slashes=0;slashes<=j;slashes++) {
				System.out.print("/\\");
		    }for(int dot =size-1;dot>j; dot--) {
				System.out.print("•");
		    }for(int bar=0;bar<1;bar++){
				System.out.print("|");
		    }System.out.println();
	}}
	public static void Section2b(int size){
		for(int j=0; j<size;j++) {
			for(int bar=0;bar<1;bar++){
				System.out.print("|");
			}for(int dot =0;dot<j; dot++) {
				System.out.print("•");
			}for(int slashes=size-1;slashes>=j;slashes--) {
				System.out.print("\\/");
			}for(int dots =0;dots<j; dots++) {
				System.out.print("••");
		    }for(int slashes=size-1;slashes>=j;slashes--) {
				System.out.print("\\/");
		    }for(int dot =0;dot<j; dot++) {
				System.out.print("•");
		    }for(int bar=0;bar<1;bar++){
				System.out.print("|");
		    }System.out.println();
		    }}
	public static void Divider(int size){
		System.out.print("+");
		for(int d=0;d<=size; d++ ){
			System.out.print("=*");
	}System.out.println("+");
}}


