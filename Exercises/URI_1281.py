cases = int(input())

for i in range(cases):
    products = int(input())
    market = {}
    for j in range(products):
        product  = input().split(" ")
        market[product[0]] = float(product[1])
    
    counter = 0
    products = int(input())
    for j in range(products):
        product = input().split(" ")
        counter = market[product[0]] * int(product[1])

    print("R$ %.2f" % counter)