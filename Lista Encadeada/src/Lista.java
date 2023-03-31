public class Lista {
    int size;
    No head;

    public Lista() {
        this.size = 0;
        this.head = null;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return (size == 0);
    }

    // Retorna o tamanho da lista
    public int getSize() {
        return size;
    }

    // Retorna o elemento de uma determinada posição na lista
    public int getElement(int position) {
        if (position >= size) {
            throw new IndexOutOfBoundsException();
        }

        No current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Modifica o valor do elemento de uma determinada posição na lista
    public void setElement(int position, int value) {
        if (position >= size) {
            throw new IndexOutOfBoundsException();
        }

        No current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        current.data = value;
    }

    // Insere um elemento em uma determinada posição na lista
    public void insert(int position, int value) {
        if (position > size) {
            throw new IndexOutOfBoundsException();
        }

        No newNode = new No(value);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            No current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    // Remove um elemento de uma determinada posição na lista
    public void remove(int position) {
        if (position >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (position == 0) {
            head = head.next;
        } else {
            No current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;
        }

        size--;
    }

    // Imprime os elementos de toda a lista
    public void printList() {
        No current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
