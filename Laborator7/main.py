import math
import random
import numpy as np


def read_trainig_data():
    file = open("text.txt", "r")
    return file.read()


def get_training_data(fileName):
    file = open(fileName, "r")  # opens the file in read mode
    values_per_line = file.read().splitlines()  # puts the file into an array
    file.close()
    values = []
    y = []
    for x in values_per_line:
        value = [int(values) for values in x.split(',')]
        values.append(value[:-1])
        y.append(int(x[-1]))
    return values, y


def sigmoid_function(n):
    return 1 / (1 + math.exp(n))


def sigmoid(z):
    return 1.0 / (1.0 + np.exp(-z))


def derivative_sigmoid_function(n):
    return sigmoid_function(n) * (1 - sigmoid_function(n))


def derivata_sigmoid(z):
    return sigmoid(z) * (1 - sigmoid(z))


class NeuralNetwork:
    def __init__(self, dimensions):
        self.no_epochs = int(input("Maximum number of epochs: "))
        self.learning_rate = float(input("Learning rate: "))

        # self.weights = []
        # for i in range (1, 3):
        #     self.weights.append(random.uniform(-0.5, 0.5))
        # print(self.weights)

        self.weights = [np.random.randn(y, x) / np.sqrt(x) for x, y in zip(dimensions[:-1], dimensions[1:])]

    def forward_propagation(self, x_train):
        for weight in self.weights:
            o = sigmoid_function(np.dot(x_train, weight))
        return o

    def train(self, x, y):
        for i in range(self.no_epochs):
            corectii_a = [np.zeros(w.shape) for w in self.weights]
            delta_corectii_w = self.backpropagation(x, y)
            corectii_a = [nw + dnw for nw, dnw in zip(corectii_a, delta_corectii_w)]
            self.weights = [w + vw for w, vw in zip(self.weights, corectii_a)]

    def backpropagation(self, x, y):
        corectii_w = [np.zeros(w.shape) for w in self.weights]
        activation = x
        list_activations = [x]
        list_z = []
        for w in self.weights:
            print("w = ", w)
            print("activation = ", activation)
            z = np.dot(w, activation)
            list_z.append(z)
            activation = sigmoid(z)
            list_activations.append(activation)

        delta = (y - list_activations[-1]) * derivata_sigmoid(list_z[-1])
        corectii_w[-1] = self.learning_rate * np.dot(delta, list_activations[-2].transpose())
        return corectii_w


# print(read_trainig_data())
x, y = get_training_data(("text.txt"))
print(x)
print(y)
print(sigmoid_function(1))
nn = NeuralNetwork([2, 1, 4])
nn.train(x, y)
