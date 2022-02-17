public class ArrayDeque<T> {
    private T items[];
    private int size;
    private int first;
    private int nextFirst;
    private int last;
    private int nextLast;
    private boolean hasFirst;
    private boolean hasLast;
    private int numberOfItemsInArray;

    public ArrayDeque() {
        size = 8;
        items = (T[])new Object[size];
        first = nextFirst = size / 2 - 1;
        last = nextLast = size / 2;
        hasFirst = false;
        hasLast = false;
        numberOfItemsInArray = 0;
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            // need to resize
            System.out.println("Need To Resize");
            this.resize();
        }

        items[nextFirst] = item;

        if (nextFirst - 1 < 0) {
            nextFirst = size - 1;
        } else {
            nextFirst -= 1;
        }

        numberOfItemsInArray += 1;
        hasFirst = true;
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            resize();
            System.out.println("Need To Resize");
        }

        items[nextLast] = item;

        if (nextLast + 1 >= size) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }

        numberOfItemsInArray += 1;
        hasLast = true;
    }

    public void resize() {
        T[] newItems = (T[]) new Object[size*2];
        int newSize = size * 2;
        int newFirst = size - 1;
        int newNextFirst = newFirst;
        int newLast = size;
        int newNextLast = newLast;

        if (this.nextFirst >= this.first && hasFirst) {
            int numOfItemsToCopy = this.size / 2;
            System.arraycopy(items, 0, newItems, newNextFirst - numOfItemsToCopy + 1, numOfItemsToCopy);

            newNextFirst -= this.size / 2;
            numOfItemsToCopy = this.size - this.nextFirst - 1;
            int oldSI = this.size - 1 - numOfItemsToCopy;
            if (numOfItemsToCopy == 1) {
                oldSI = this.size - 1;
            }
            System.arraycopy(items, oldSI, newItems, newNextFirst - numOfItemsToCopy + 1, numOfItemsToCopy);

            newNextFirst -= numOfItemsToCopy;
            if (newNextFirst < 0) {
                newNextFirst = newSize - 1;
            }
        } else if (hasFirst) {
            int numberOfItemsToCopy = first - newFirst + 1;
            System.arraycopy(items, first - numberOfItemsToCopy, newItems, newNextFirst - numberOfItemsToCopy - 1, numberOfItemsToCopy);
            newNextFirst -= numberOfItemsToCopy;
        }

        if (this.nextLast <= this.last && hasLast) {
            int numberOfItemsToCopy = this.size / 2;
            System.arraycopy(items, this.last, newItems, newNextLast, numberOfItemsToCopy);
            newNextLast += numberOfItemsToCopy;

            numberOfItemsToCopy = nextLast;
            System.arraycopy(items, 0, newItems, newNextLast, numberOfItemsToCopy);
            newNextLast += numberOfItemsToCopy;

            if (newNextLast >= newSize) {
                newNextLast = 0;
            }
        } else if (hasLast){
            int numberOfItemsToCopy = this.nextLast - this.last;
            System.arraycopy(items, this.last, newItems, newLast, numberOfItemsToCopy);

            newNextLast += numberOfItemsToCopy;

            if (newNextLast >= newSize) {
                newNextLast = 0;
            }
        }

        items = newItems;
        this.first = newFirst;
        this.last = newLast;
        this.nextFirst = newNextFirst;
        this.nextLast = newNextLast;
        this.size = newSize;
    }

    public int size() {
        return this.numberOfItemsInArray;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addFirst(20);
        AD.addFirst(19);
        AD.addFirst(18);
        AD.addFirst(17);


        AD.addLast(10);
        AD.addLast(9);
        AD.addLast(8);
        AD.addLast(7);
        AD.addLast(6);

        AD.addFirst(16);
        AD.addFirst(15);
        AD.addFirst(14);
        AD.addFirst(13);
        AD.addFirst(12);

        AD.addLast(5);
        AD.addLast(4);
        AD.printDeque();

        AD.addLast(3);
        AD.addLast(2);
        AD.addLast(1);

        AD.printDeque();
        System.out.println(AD.size());
    }
}
