package javalearning.enums;

/**
 * @Author: Jeremy
 * @Date: 2019/5/23 16:24
 */
public enum Season {
    /**
     * 春天
     */
    SPRING(1),
    /**
     * 夏天
     */
    SUMMER(2),
    /**
     * 秋天
     */
    FALL(3),
    /**
     * 冬天
     */
    WINTER(4);

    private final Integer season;
    Season(Integer season){
        this.season = season;
    }
}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumOne
{
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
    }
}

