Items = []
on = False
def show():
    print('--------------------------')
    print('id'+' '+'name'+' '+'qty'+' '+'price')
    for i in Items:
        val = ''
        for j in i:
            val+=str(j)
            val+=' '
        print(val)
    print('--------------------------')
                    
def Add():
    print('Enter Items - ')
    temp = []
    temp.append(len(Items)+1)
    temp.append(input('Enter Name:'))
    temp.append(int(input('Enter qty:')))
    temp.append(float(input('Enter price:')))
    Items.append(temp)
    show()

def update():
    show()
    item_id = int(input('Enter the id you wanna update:'))
    print('---------------------------------')
    print("1. item name")
    print("2. item qty")
    print("3. item price")
    choice = int(input('Enter the item no you wanna update:'))
    val = ''
    if choice==1:
        val = input('Enter name:')
    elif choice==2:
        val = int(input('Enter qty:'))
    elif choice==2:
        val = float(input('Enter price:'))
        
    for i in Items:
        if i[0]==item_id:
            i[choice] = val
    print('Item Updated Successfully!!')
    show()  

def delete():
    show()
    item_id = int(input('Enter the id you wanna delete:'))
    print('---------------------------------')
    for i in Items:
        if i[0]==item_id:
            Items.pop(i)
    print('Item Deleted Successfully')
    print('---------------------------------')
    show()

def Buy():
    print('Calculating Sum total of all items:')
    show()
    sum = 0
    for i in Items:
       sum+=i[2]*i[3] 
    print('sum:\t',sum)

def close():
    global on
    on = False
    
def menu():
    print("Inventory Management System")
    print("---------------------------")
    print("1. Add Items")
    print("2. Update Items")
    print("3. Delete Items")
    print("4. Show All Items")
    print("5. Buy and generate Recipt")
    print("0. Exit")
    print("---------------------------")
    choice = int(input("Enter your choice:"))
    global on
    on = True
    while(choice!=0 and on):
        if(choice==1):
            Add()
        elif(choice==2):
            update()
        elif(choice==3):
            delete()
        elif(choice==4):
            show()
        elif(choice==5):
            Buy()
        elif(choice==0):
            close()
        choice = int(input("Enter your choice:"))
                

menu()

            

   
    
