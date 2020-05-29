import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class TestIteracAggregator implements ArgumentsAggregator {

    @Override
    public TestIterace aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) {
        return new TestIterace(accessor.getString(0),
                accessor.getString(1),
                accessor.getString(2),
                accessor.getString(3),
                accessor.getString(4),
                accessor.getString(5),
                accessor.getString(6),
                accessor.getString(7),
                accessor.getString(8),
                accessor.getString(9),
                accessor.getString(10),
                accessor.getString(11));
    }


}
