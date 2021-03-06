/*******************************************************************************
 * Copyright (c) 2014, MD PnP Program
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package drivers.philips.intellivue.data;

import java.nio.ByteBuffer;
import java.util.Map;

import common.io.util.Bits;
import drivers.philips.intellivue.OrdinalEnum;

/**
 * @author Jeff Plourde
 *
 */
public enum PatientPacedMode implements EnumMessage<PatientPacedMode>, OrdinalEnum.IntType {
    PAT_NOT_PACED(0), PAT_PACED_GEN(1);

    @Override
    public void format(ByteBuffer bb) {
        Bits.putUnsignedShort(bb, asInt());
    }

    @Override
    public PatientPacedMode parse(ByteBuffer bb) {
        return PatientPacedMode.valueOf(Bits.getUnsignedShort(bb));
    }

    private final int x;

    private PatientPacedMode(final int x) {
        this.x = x;
    }

    private static final Map<Integer, PatientPacedMode> map = OrdinalEnum.buildInt(PatientPacedMode.class);

    public static PatientPacedMode valueOf(int x) {
        return map.get(x);
    }

    public int asInt() {
        return x;
    }
}
