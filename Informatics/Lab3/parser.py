import time
start_time = time.time()
input = open("timetable.xml", "r", encoding="UTF-8")
output = open("timetable.yml", "w", encoding="UTF-8")
f = input.read().split("\n")
k = 0
for line in f:
    a = line.replace("<", ">").split(">")
    if line.count("/") == 1:
        if line.count("<") > 1:
            output.write(" " * k + a[1] + ': "' + a[2] + '"\n')
        else:
            k -= 1
    else:
        output.write(" " * k + a[1] + ":" + "\n")
        k += 1
input.close()
output.close()
print((time.time()-start_time))