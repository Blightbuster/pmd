/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import java.util.Iterator;


/**
 * An array initializer. May occur in two syntactic contexts:
 * <ul>
 * <li>The right-hand side of a {@linkplain ASTVariableDeclarator variable declarator}
 * <li>Inside an {@linkplain ASTArrayAllocation array allocation expression}
 * </ul>
 *
 * <pre class="grammar">
 *
 * ArrayInitializer ::= "{" ( "," )? "}"
 *                    | "{" {@link ASTExpression Expression} ( "," {@link ASTExpression Expression} )* ( "," )? "}"
 *
 * </pre>
 *
 */
public final class ASTArrayInitializer extends AbstractJavaExpr implements ASTExpression, Iterable<ASTExpression> {

    ASTArrayInitializer(int id) {
        super(id);
    }

    public ASTArrayInitializer(JavaParser p, int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }


    @Override
    public Iterator<ASTExpression> iterator() {
        return new NodeChildrenIterator<>(this, ASTExpression.class);
    }
}
