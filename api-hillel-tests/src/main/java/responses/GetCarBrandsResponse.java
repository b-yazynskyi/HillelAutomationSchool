package responses;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class GetCarBrandsResponse {
    private String status;
    private List<Brand> data;

    @Data
    public static class Brand {
        private int id;
        private String title;
        private String logoFileName;
    }
}
