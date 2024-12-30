package responses;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetCarBrandsResponse {
    private String status;
    private List<Brand> data;


    public class Brand {
        private int id;
        private String title;
        private String logoFileName;
    }
}
