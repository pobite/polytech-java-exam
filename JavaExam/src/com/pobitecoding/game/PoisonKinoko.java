package com.pobitecoding.game;

public class PoisonKinoko extends Kinoko {

    private int poisonCnt = 5;
    
    public PoisonKinoko(char suffix) {
        super(suffix);
    }
    
    public int getPoisonCnt() {
        return poisonCnt;
    }

    public void setPoisonCnt(int poisonCnt) {
        this.poisonCnt = poisonCnt;
    }

    @Override
    public void attack(Hero hero) {
        
        // a. 우선, “보통 괴물버섯과 같은 공격"을 한다
        super.attack(hero);
        
        // b. “독 공격의 남은 횟수"가 0이 아니면 다음을 추가로 수행한다
        if (poisonCnt  != 0) {
            
            // c. 화면에 “추가로, 독 포자를 살포했다!” 를 표시
            System.out.println("추가로, 독 포자를 살포했다!");
            
            // d. 용사의 HP 의 1/5에 해당하는 포인트를 용사의 HP 로부터 감소시키고,
            // “~포인트의 데미지" 라고 표시
            int reduceHp = hero.getHp() / 5;
            hero.setHp(reduceHp);
            System.out.println(reduceHp + "포인트의 데미지");
            
            // e.“독 공격의 남은 횟수" 를 1 감소 시킨다
            poisonCnt--;
        }
    }
}