package strategy;

/**
 * Created by yangtianrui on 16-7-5.
 * <p>
 * ���������������������
 */
public class Main {
    public static void main(String[] args) {
        // ��ʼ���佫����
        Zhaoyun zhaoyun = new Zhaoyun();

        // �𿪵�һ������
        zhaoyun.setContext(new Context(new BackDoor()));
        // ִ��
        zhaoyun.operate();

        // �𿪵ڶ�������
        zhaoyun.setContext(new Context(new GreenLight()));
        // ִ��
        zhaoyun.operate();

        // �𿪵���������
        zhaoyun.setContext(new Context(new BackEnemy()));
        // ִ��
        zhaoyun.operate();
    }
}
//  ִ�н��:
//  ���ǹ��ϰ�æ�������̫����Ȩʩ��ѹ����ʹ��Ȩ����ɱ����...
//  �����̫�����̵ƣ����У�
//  ����˶Ϻ󣬵�ס׷��...
