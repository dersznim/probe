#uruchomienie środowiska
from typing import Tuple

print("Hello")
#podstawowe funkcje
#zamiana wartości w ciągu liczb
print('1234'.replace('3',"a"))
#detekcja klasy
n=1
print(n.__class__)
p=1.0
print(p.__class__)
#sortowanie
k=[2,1,5,6,4,7,1]
k.sort()
print(k)
#nie jest prawidłowy zapis, bo wykona się wyłącznie sortowanie
print(k.sort())
#składnia pythona
cyfry=(1,2,3,4,5,6,7,8,9)
for a in cyfry:
 for b in cyfry:
     print('%s x %s =%s'%(a,b,a*b))

#proste obliczenia
dlugosc=15
szerokosc=2
obszar = dlugosc * szerokosc
print('Powierzchnia prostokąta = %s' % (obszar))
print('Powierzchnia =%s' %(dlugosc*szerokosc))
print('Obwód =%s'%(2*(dlugosc+szerokosc)))
obwod=2*(dlugosc+szerokosc)
print('obwod=%s'%(obwod))

#przetwarzanie małych ilości danych
import csv
import numpy
ages=[]
with open('lista.csv') as csvfile:
    readCSV = csv.reader(csvfile, delimiter=';')
    for row in readCSV:
        ages.append(int(row[2]))
        m=numpy.median(ages)
        print('medana wieku=%s'%(m))
    print(ages)
    ages.append((7))
    m=numpy.median(ages)
    print('medana wieku=%s'%(m))
    ages.sort()
    print(ages)

#instrukcja for
for i in range(1,5):
    print(i)
else:
    print('zrobione')

for i in range(1, 10,2):
    print(i)
else:
    print('zrobione')

#listy
    lista=list(range(5))
    print(lista)
    print(lista[0])
listazakupow=['jabłka','mango','marcherw','banany']
listazakupow.append('ryz dla sasiadki')
for item in listazakupow:
    print('rzeczy do kupienia : %s'%(item))

listazakupow.sort()
for item in listazakupow:
        print('posotowane rzeczy do kupienia : %s' % (item))

print('najwazniejsza rzecza do kupienia jest :%s '% (listazakupow[2]))
del listazakupow[1]
print(listazakupow)
m=len(listazakupow)
print('ilość rzeczy na liście to : %s'%m)
listazakupow.remove('banany')
print(listazakupow)

#krotki-nie mozna ich modyfikować
zoo=('python','słon','papuga')
print(zoo)
new_zoo='małpa','polichlorek',zoo
print(new_zoo)
print('ilość krotek w nowym zoo :%s'%len(new_zoo))
print('ilosc zwierzat w nowym zoo : %s'%(len(new_zoo)-1+len(new_zoo[2])))
print('ktos ze starego zoo : %s'%new_zoo[2][1])
#warto pamietać i uwarzać na przecinki
a=1,
krotka=1,a,3
print(krotka)


#Słowniki
ksiazka={
    'email': 'mateusz.derszniak@wp.pl',
    'telefon':'987475321',
    'imie': 'Mateusz',
}
print(ksiazka['email'])
print(dict.keys(ksiazka))
print(dict.items(ksiazka))
print(dict.values(ksiazka))
del ksiazka['email']
print(ksiazka)
#if
"""
print('\n'*80)
numer=23
pobierana=int(input('podaj liczbę załkowitą'))
if pobierana == numer:
    print('\n' * 80)
    print('dobra liczba')
elif pobierana < numer:
    print('\n' * 80)
    print('wpiana liczba powienna być większa')
else:
    print('\n' * 80)
    print('pobrana liczba powinna być mniejsza')
print('koniec')
"""
#while
"""
numer=23
spr=True
while spr :
    pobrana=int(input('podaj liczbe'))
    if pobrana == numer:
        print('pobrana liczba jest liczbą poprawną')
        spr=False
    elif pobrana<numer :
        print('pobrana liczba jest za mała i powinna być większa')
    else:
        print('pobrana liczba powinna być mniejsza')
else:
    print('koniec')
   """
#break&continue
"""
point=7
suma= point
print('możesz zakończyć sumowanie wpisując 0')
while suma < 21:
    point=int(input('podaj liczbe od 0 do 12'))
    if point <0 or point >12:
        print('od 0 do 12')
        continue
    elif point==0:
        break
    suma+=point
print('Suma:%s' %suma)
"""
#funkcje
"""
def szyfruj(liczba1,liczba2):
    return(liczba1+liczba2)

numer1=54
numer2=int(input('podaj liczbę'))
suma=szyfruj(numer1,numer2)
print('Suma=%s'%suma)
"""
#obiekty
class klasa():
    def metoda(self):
        print(self.wlasnosc)

obiekt1=klasa()
obiekt1.wlasnosc=1
obiekt2=klasa()
obiekt2.wlasnosc=2
obiekt1.metoda()
obiekt2.metoda()
#moduły

from clipher import Tszyfr
"""
szyfrant=Tszyfr()
szyfrant.klucz=89
szyfrant.klucze=-5
wiadomość=int(input('podaj dodatnią liczbę do szyfrowania'))
szyfr=szyfrant.szyfruj(wiadomość)
szyfrtajny=szyfrant.szyfrujtajnie(wiadomość)
print('Szyfr=%s'%szyfr)
print('szyfr tajny =%s'%szyfrtajny)
print('odszyfruj: %s'%szyfrant.deszyfruj(szyfr))
print('odszyfruj tajnie=%s'%szyfrant.deszyfrujtajnie(szyfrtajny))
"""
#dziedziczenie
"""
from dziedziczenie import Tdszyfr
szyfrant=Tdszyfr(88)
wiadomosc= input('podaj napis')
szyfr=szyfrant.s_szyfruj(wiadomosc)
print('wynike to %s'%szyfr)
print('deszyfr to %s'%szyfrant.s_deszyfruj(szyfr))
"""
#pakiety
"""
from pakiety.dziedziczenie import Tdszyfr
szyfrant=Tdszyfr(88)
wiadomosc= input('podaj napis')
szyfr=szyfrant.s_szyfruj(wiadomosc)
print('wynike to %s'%szyfr)
print('deszyfr to %s'%szyfrant.s_deszyfruj(szyfr))
"""
# Dekoratory
"""
from flask import Flask, escape, request

app = Flask(__name__)

@app.route('/')
def hello():
    name = request.args.get("name", "World")
    return f'Hello, {escape(name)}!'
"""
#Sekwencje
"""
krotka=[0,1,2,3,4,5]
print(krotka)
print(krotka[1])
print(krotka[-1])
print(krotka[1:3])
print(krotka[1:-1])
print(krotka[:4])

słowo=input('podaj słowo')
print('pierwsza litera to %s'%słowo[0])
print('ostatnia litera  to %s'%słowo[-1])
print('środkowe litery to %s'%słowo[len(słowo)-1])
"""
# Referencje i kopie
"""
print(listazakupow)
print('referencja')
mylist=listazakupow
print(mylist)
print('usuwam z listyzakupów')
del listazakupow[0]
print('lista zakupów %s'%listazakupow)
print('mylist %s'%mylist)

print('kopia z sekwencji')
mylist=listazakupow[:]
print(mylist)
print('usuwam z listyzak'
      'upów')
del listazakupow[0]
print('lista zakupów %s'%listazakupow)
print('mylist %s'%mylist)
"""
#łańcuchy znaków
name= 'polichlorek'
print(name)
print('zmiana pierwszej litery na wielką')
name=name.capitalize()
print(name)
if name.startswith('Pol'):
    print('nazwa zaczyna się od Pol')
if 'a' in name:
    print('w łańcuchy jest a')
elif name.find('rek')!=-1:
    print('w nazwie jest rek')

print(name.upper())
print(name.lower())
print('sprawdzenie ilosci litery L  %s'%name.count('a'))
print(list('aaa'))
print('aaa bbb ccc'.split(' '))
print(''.join(['a','b','c']))
tablica=[]
for znak in name :
    tablica.append(ord(znak))
print(tablica)
wynik=''
for krok in tablica:
    wynik=wynik+chr(krok)
print (wynik)
cos=1
swa=12.34
czx=213.4
print(' coś %.01f,coss %s, soos %s'%(cos,swa,czx))

#funkcje

def powiedzAjo():
    print('ajo, przygodo !!!')
powiedzAjo()
powiedzAjo()

def suma1(a,b):
    print(a+b)
    a=a+b
def suma2(a):
    print(a[0]+a[1])
    a[0]=a[0]+a[1]
a=3
suma1(a,2*3)
print('parametr na wyjsciu suma a=',a)
suma2([3,6])
liste=[3,6]
suma2(liste)
print('suma22=',liste)

def maximum(x,y):
    if x>y:
        return x
    else:
        return y

print(maximum(2,3))

def funkacja():
    pass

print (funkacja())