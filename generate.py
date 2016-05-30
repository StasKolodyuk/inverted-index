import sys
import wikipedia

for i in range(1, int(sys.argv[1])):
    page = wikipedia.page(wikipedia.random())
    print "Creating " + page.title.encode("utf-8") + ".txt ..."
    with open("input/" + page.title.encode("utf-8") + ".txt", "a+") as file:
        file.write(page.title.encode("utf-8") + "\n")
        file.write(page.content.encode("utf-8"))
