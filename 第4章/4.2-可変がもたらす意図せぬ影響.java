// 攻撃力を表現するクラス

// class AttackPower {
//   static final int MIN = 0;
//   int value; // finalが付いてないので可変

//   AttackPower(int value) {
//     if (value < MIN) {
//       throw new IllegalArgumentException();
//     }

//     this.value = value;
//   }
// }

// 武器を表現するクラス

// class Weapon {
//   final AttackPower attackPower;

//   Weapon(AttackPower attackPower) {
//     this.attackPower = attackPower;
//   }
// }

// class Test {
//   static void main() {
//     AttackPowerインスタンスを使い回している
    
//     AttackPower attackPower = new AttackPower(20);
    
//     Weapon weaponA = new Weapon(attackPower);
//     Weapon weaponB = new Weapon(attackPower);
    
//     使い回している攻撃力を変更すると...？
    
//     AttackPower attackPower = new AttackPower(20);
    
//     Weapon weaponA = new Weapon(attackPower);
//     Weapon weaponB = new Weapon(attackPower);
    
//     weaponA.attackPower.value = 25;

//     System.out.println("Weapon A attack power : " + weaponA.attackPower.value);
//     System.out.println("Weapon B attack power : " + weaponB.attackPower.value);

//     別の武器の攻撃力まで変化してしまう

//     Weapon A attack power : 25
//     Weapon B attack power : 25

//     攻撃力のインスタンスを個別に生成する

//     AttackPower attackPowerA = new AttackPower(20);
//     AttackPower attackPowerB = new AttackPower(20);
    
//     Weapon weaponA = new Weapon(attackPowerA);
//     Weapon weaponB = new Weapon(attackPowerB);
    
//     weaponA.attackPower.value += 5;

//     System.out.println("Weapon A attack power : " + weaponA.attackPower.value);
//     System.out.println("Weapon B attack power : " + weaponB.attackPower.value);

//     使い回しをやめると影響しなくなる

//     Weapon A attack power : 25
//     Weapon B attack power : 20
//   }
// }

// 攻撃力を変化させるメソッドを追加

// class AttackPower {
//   static final int MIN = 0;
//   int value;

//   AttackPower(int value) {
//     if (value < MIN) {
//       throw new IllegalArgumentException();
//     }

//     this.value = value;
//   }

//   /**
//    * 攻撃量を強化する
//    * @param increment 攻撃力の増分
//    */
//   void reinForce(int increment) {
//     value += increment;
//   }

//   /** 無力化する */
//   void disable() {
//     value = MIN;
//   }
// }

// 不変で堅牢になったAttackPowerクラス

class AttackPower {
  static final int MIN = 0;
  final int value; // finalで不変にする

  AttackPower(final int value) {
    if (value < MIN) {
      throw new IllegalArgumentException();
    }

    this.value = value;
  }

  /**
   * 攻撃力を強化する
   * @param increment 攻撃力の増分
   * @return 強化された攻撃力
   */
  AttackPower reinForce(final AttackPower increment) {
    return new AttackPower(this.value + increment.value);
  }

  /**
   * 無力化する
   * @return 無力化された攻撃力
   */
  AttackPower disable() {
    return new AttackPower(MIN);
  }
}

// 武器を表現するクラス (改良版)

class Weapon {
  final AttackPower attackPower;

  Weapon(final AttackPower attackPower) {
    this.attackPower = attackPower;
  }

  /**
   * 武器を強化する
   * @param increment 攻撃力の増分
   * @return 強化した武器
   */
  Weapon reinForce(final AttackPower increment) {
    final AttackPower reinForced = attackPower.reinForce(increment);
    return new Weapon(reinForced);
  }
}

class Test {
  void main() {
    // 影響範囲が閉じた攻撃力強化

    // final AttackPower attackPower = new AttackPower(20);
    // final AttackPower reinForced = attackPower.reinForce(new AttackPower(15));
    // System.out.println("attack power : " + reinForced.value);

    // 別のインスタンスを生成するので影響なし
    
    // 別のスレッド処理
    // final AttackPower disabled = attackPower.disable();

    // AttackPowerとWeaponの利用(改良版)

    final AttackPower attackPowerA = new AttackPower(20);
    final AttackPower attackPowerB = new AttackPower(20);

    final Weapon weaponA = new Weapon(attackPowerA);
    final Weapon weaponB = new Weapon(attackPowerB);

    final AttackPower increment = new AttackPower(5);
    final Weapon reinForcedWeaponA = weaponA.reinForce(increment);

    System.out.println("Weapon A attack power : " + weaponA.attackPower.value);
    System.out.println("Reinforced weapon A attack power : " + reinForcedWeaponA.attackPower.value);
    System.out.println("Weapon B attack power : " + weaponB.attackPower.value);

    // それぞれが影響を受けない
    // Weapon A attack power : 20
    // Reinforced weapon A attack power : 25
    // Weapon B attack power : 20
  }
}