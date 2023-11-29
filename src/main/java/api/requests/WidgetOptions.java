package api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WidgetOptions {
    private boolean zoom;
    private String timeline;
    private String viewMode;
}
