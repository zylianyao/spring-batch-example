/**
 *
 */
package com.juxtapose.example.ch02;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 *         2013-1-6下午09:55:38
 */
public class CreditBillProcessor implements
        ItemProcessor<CreditBill, CreditBill> {

    public CreditBill process(CreditBill bill) throws Exception {
        bill.setName("name:" + bill.getName());
        bill.setAccountID("accountID:"+bill.getAccountID());
        System.out.println(bill.toString());
        //这里 return 的数据回交给写操作进行处理
        return bill;
    }
}
