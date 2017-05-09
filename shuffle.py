import random

fichas=[0,1,2,3,
        4,5,6,7,
        8,9,10,11,
        12,13,14," "]
# tomando en cuenta que la esquina esta vacia
mov=[-4,-1,1,4]
n=20 #numero de movimientos
FFalt=7
print(fichas)
for i in range(n):
    if fichas[15]==" ":
        a=random.randrange(2)
        fichas[15],fichas[15+mov[a]]=fichas[15+mov[a]],fichas[15]
    elif fichas[0]==" ":
        a=random.randrange(2)
        fichas[0],fichas[0+mov[a+2]]=fichas[0+mov[a+2]],fichas[0]
    elif fichas[3]==" ":
        a=random.randrange(2)
        if a==0:
            fichas[3],fichas[3+mov[a+1]]=fichas[3+mov[a+1]],fichas[3]
        else:
            fichas[3],fichas[3+mov[a+2]]=fichas[3+mov[a+2]],fichas[3]
    elif fichas[12]==" ":
        a=random.randrange(2)
        if a==0:
            fichas[12],fichas[12+mov[a]]=fichas[12+mov[a]],fichas[12]
        else:
            fichas[12],fichas[12+mov[a+1]]=fichas[12+mov[a+1]],fichas[12]
    elif fichas[1]==" " or fichas[2]==" ": #se podria saber donde esta la ficha faltante
        a=random.randrange(3)
        fichas[FFalt],fichas[FFalt+mov[a+1]]=fichas[FFalt+mov[a+1]],fichas[FFalt]
    elif FFalt>12 and FFalt<15:
        a=random.randrange(3)
        fichas[FFalt],fichas[FFalt+mov[a]]=fichas[FFalt+mov[a]],fichas[FFalt]
    elif FFalt==4 or FFalt==8:
        a=random.randrange(3)
        if a>0:
            a=a+1
        fichas[FFalt],fichas[FFalt+mov[a]]=fichas[FFalt+mov[a]],fichas[FFalt]
    elif FFalt==7 or FFalt==11:
        a=random.randrange(3)
        if a==2:
            a=a+1
        fichas[FFalt],fichas[FFalt+mov[a]]=fichas[FFalt+mov[a]],fichas[FFalt]
    else:
        a=random.randrange(4)
        fichas[FFalt],fichas[FFalt+mov[a]]=fichas[FFalt+mov[a]],fichas[FFalt]
print (fichas)
