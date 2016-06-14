package it.polimi.polidemonstrator.businesslogic.businessrules;

/**
 * Created by saeed on 6/13/2016.
 */
import java.util.Stack;

public class ExpressionParser
{
    private static final Operations operations = Operations.INSTANCE;

    public static Expression fromString(String expr)
    {
        Stack<Expression> stack = new Stack<>();

        String[] tokens = expr.split("\\s");
        for (int i=0; i < tokens.length-1; i++)
        {
            Operation op = operations.getOperation(tokens[i]);
            if ( op != null )
            {
                // create a new instance
                op = op.copy();
                i = op.parse(tokens, i, stack);
            }
        }

        return stack.pop();
    }
}
