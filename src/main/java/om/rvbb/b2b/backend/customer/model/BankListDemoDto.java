package om.rvbb.b2b.backend.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankListDemoDto {    
    private String bankname;    
    private int type;        
}
