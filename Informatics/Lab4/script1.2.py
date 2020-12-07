import re
s = input()
pattern = re.compile('(?<![\.\,\d])\d+(?![\.\,\d])')
original = pattern.findall(s)
for i in original:
    n = int(i)
    n = 3 * n * n + 5
    s = s.replace(i, str(n))

print(s)