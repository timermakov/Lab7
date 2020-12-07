import re
v = 'aeiouyAEIOUY'
w = '^\s.!?'
text = open('Hamlet.txt', encoding='utf8').read()
f = open('result.txt', 'w', encoding="utf8")
for match in re.finditer(rf'[A-Z]([{w}]+(?!\n\s\S)\s+){{5}}[{w}]+[.!?]', text):
    s = match.group()
    if re.search(rf'[\s.!?][{w}{v}]*([{v}][{w}{v}]*){{2}}[\s.!?]', s):
        f.write(' '.join(s.split()) + "\n")