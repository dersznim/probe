from pakiety.clipher import Tszyfr
class Tdszyfr(Tszyfr):
    def s_szyfruj(self,napis):
        wynik=[]
        for znak in napis:
            wynik.append(self.szyfruj(ord(znak)))
        return wynik

    def s_deszyfruj(self,zakodowany):
        wynik=''
        for kod in zakodowany:
            wynik=wynik+chr(self.deszyfruj(kod))
        return wynik