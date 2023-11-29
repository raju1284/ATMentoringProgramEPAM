package api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddWidget {
    private int widgetId;
    private String widgetName;
    private WidgetOptions widgetOptions;
    private WidgetPosition widgetPosition;
    private WidgetSize widgetSize;
    private String widgetType;
}
