import math


def read_trainig_data():
    file = open("text.txt", "r")
    return file.read()


def get_training_data(fileName):
    file = open(fileName, "r")  # opens the file in read mode
    values_per_line = file.read().splitlines()  # puts the file into an array
    file.close()
    values = []
    for x in values_per_line:
        for i in x:
            values.append(int(x[(int(i))]))
    return values


def sigmoid_function(n):
    return 1 / (1 + math.exp(n))


def derivative_sigmoid_function(n):
    return sigmoid_function(n) * (1 - sigmoid_function(n))


# print(read_trainig_data())
print(get_training_data(("text.txt")))
print(sigmoid_function(1))
