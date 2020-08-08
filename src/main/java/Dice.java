
public class Dice { //����� �����

    private int numOfEdges; //���������� ������

    public Dice(int number){
        this.numOfEdges = number;
    }

    public int throwDice(){ //������
        return (int) (Math.random() * this.numOfEdges + 1);

    }
}