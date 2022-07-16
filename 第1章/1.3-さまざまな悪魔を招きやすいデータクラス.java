// データしか持たないありがちなクラス構造

// 契約金額
public class ContractAmount {
  public int amountIncludingTax; // 税込金額
  public BigDecimal salesTaxRate; // 消費税率
}

// ContractManagerに書かれる金額計算ロジック

// 契約を管理するクラス
public class ContractManager {
  public ContractAmount contractAmount;

  // 税込金額を計算する。
  public int calculateAmountIncludingTax(int amountExcludingTax, BigDecimal salesTaxRate) {
    BigDecimal multiplier = salesTaxRate.add(new BigDecimal("1.0"));
    BigDecimal amountIncludingTax = multiplier.multiply(new BigDecimal(amountExcludingTax));
    return amountIncludingTax.intValue();
  }

  // 契約を締結する。
  public void conclude() {
    // 省略
    int amountIncludingTax = calculateAmountIncludingTax(amountExcludingTax, salesTaxRate);
    contractAmount = new ContractAmount();
    contractAmount.amountIncludingTax = amountIncludingTax;
    contractAmount.salesTaxRate = salesTaxRate;
    // 省略
  }
}

// 生焼けオブジェクト

ContractAmount amount = new ContractAmount();
System.out.println(amount.salesTaxRate.toString());

// 不正値を混入可能

ContractAmount amount = new ContractAmount();
amount.salesTaxRate = new BigDecimal("-1.0");