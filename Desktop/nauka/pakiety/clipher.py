class Tszyfr:
    def __init__(self,klucz):
        self.klucz=klucz
    klucze=0

    def szyfruj(self,liczba):
        return(liczba+self.klucz)
    def deszyfruj(self,liczba):
        return(liczba-self.klucz)
    def szyfrujtajnie(self,liczba):
        return(liczba+self.klucze)
    def deszyfrujtajnie(self,liczba):
        return(liczba-self.klucze)




