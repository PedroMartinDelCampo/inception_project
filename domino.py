from tkinter import *


tablero = Tk()
tablero.geometry("900x450")
tablero.title("Domino")

def tomarFicha():
    print ("Tomando ficha")

def pasarTurno():
    print ("Pasando turno")



tFicha = Button(tablero, text= "Tomar ficha", command = tomarFicha)

pTurno = Button(tablero, text= "Pasar turno", command = pasarTurno) 

tFicha.place(rely=1.0, relx=1.0, x = -5 ,y=-5, anchor=SE)
pTurno.place(rely=1.0, relx=1.0, x = -90 ,y=-5, anchor=SE)

fichas=[[0,0],
       [1,0],[1,1],
       [2,0],[2,1],[2,2],
       [3,0],[3,1],[3,2],[3,3],
       [4,0],[4,1],[4,2],[4,3],[4,4],
       [5,0],[5,1],[5,2],[5,3],[5,4],[5,5],
       [6,0],[6,1],[6,2],[6,3],[6,4],[6,5],[6,6]]

def generarFichas()
    for i in range fichas
         ficha = Button(tablero, text="      




