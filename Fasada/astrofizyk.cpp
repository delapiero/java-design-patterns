#include <iostream>
#include <fstream>
#include <cstdlib>
#include <string>

using namespace std;

int main(int argc, char* argv[]){
	// nie podano pliku
	if (!argv[1]){
		cout << "Nie podano pliku" << endl;
		return 1;
	}
	
	//otwarcie pliku
	ifstream plik;
	plik.open(argv[1]);
	if (!plik.is_open()){
		cout << "Nie mozna otworzyc pliku." << endl;
		return 2;	
	}
	
	// przetworzenie pliku
	string linijka;
	int licznik = 0;
	while( !plik.eof() ){
		
		plik >> linijka;
		
		// usuniecie komentarza
		int komentarz = linijka.find("//");
		linijka = linijka.substr(0,komentarz);
	
		// przetworzenie rozkazu -----------------------------------------------
		if ( linijka == "gwiazdka" ){
			++licznik;
		}	
	}
	
	cout << licznik << endl;
	return 0;
				
}
