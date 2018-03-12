# Version 2 used a better method of construction the initial boolean array without a for loop

# Version 3, put everything in a neat little function which increased performance drastically.
# Also deleted the intermediary print statement for the boolean array since it only served debugging purposes.
# Appended a print statement with the sum of all found primes for verification purposes.

# Version 4, experimented by constructing the array with the array library, but that yielded
# a performance decrease
# Instead of computing limit - 2 everywhere, assigned it to a variable, increased performance by >100ms
# Even shortening all variable names to 1 or 2 letter words increased performance by ~50ms
# though it makes for horrible readability
# variables reference: l = limit, sl = sieve limit, a = array, p = array of primes
# Trying to implement numpy to use its np.array feature drastically decreased performance

import time
start_time = time.time()


def sieve(l):
    sl = l - 2
    a = [True]*sl
    for i in range(sl):
        if a[i]:
            j = 2 * i + 2
            while j < sl:
                a[j] = False
                j += i + 2
    p = []
    for i in range(sl):
        if a[i]:
            p.append(i + 2)
    return p


print(sieve(2000000))
print("{0} ms".format((time.time() - start_time) * 1000))
print(sum(sieve(2000000)))
