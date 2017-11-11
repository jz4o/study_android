package jp.co.jz4o.studyandroid.ObjectListView;

/**
 * 生徒クラス.
 */
public class Student {
    /**
     * 出席番号.
     */
    private int number;

    /**
     * 名前.
     */
    private String name;

    /**
     * コンストラクタ.
     *
     * @param number 出席番号
     * @param name   名前
     */
    public Student(final int number, final String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * 出席番号を返します.
     *
     * @return 出席番号
     */
    public final int getNumber() {
        return number;
    }

    /**
     * 名前を返します.
     *
     * @return 名前
     */
    public final String getName() {
        return name;
    }
}
