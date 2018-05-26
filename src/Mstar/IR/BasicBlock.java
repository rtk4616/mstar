package Mstar.IR;

import Mstar.IR.Instruction.CJump;
import Mstar.IR.Instruction.IRInstruction;
import Mstar.IR.Instruction.Jump;
import Mstar.IR.Instruction.Return;

import java.util.LinkedList;

public class BasicBlock {
    public String hint;
    public Function function;
    public IRInstruction head;
    public IRInstruction tail;

    LinkedList<BasicBlock> frontiers;
    LinkedList<BasicBlock> successors;

    public BasicBlock(Function function, String hint) {
        this.function = function;
        this.hint = hint;
        function.basicblocks.add(this);
    }

    public boolean isEnded() {
        return tail instanceof Return || tail instanceof Jump || tail instanceof CJump;
    }

    public void append(IRInstruction inst) {
        if (head == null) {
            inst.prev = inst.next = null;
            head = tail = inst;
        } else {
            tail.append(inst);
        }
    }

    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}