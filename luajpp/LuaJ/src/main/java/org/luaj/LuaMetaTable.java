package org.luaj;

public interface LuaMetaTable {
    LuaValue __index(LuaValue luaValue);

    void __newindex(LuaValue luaValue, LuaValue luaValue2);
}