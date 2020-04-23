/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.lzy.demo.service.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-04-23")
public class ThriftMessage implements org.apache.thrift.TBase<ThriftMessage, ThriftMessage._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftMessage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftMessage");

  private static final org.apache.thrift.protocol.TField STR_FIELD_DESC = new org.apache.thrift.protocol.TField("str", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField INTEGER_FIELD_DESC = new org.apache.thrift.protocol.TField("integer", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DOU_FIELD_DESC = new org.apache.thrift.protocol.TField("dou", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField STRING_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("stringList", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField THRIFT_MESSAGE_SET_FIELD_DESC = new org.apache.thrift.protocol.TField("thriftMessageSet", org.apache.thrift.protocol.TType.SET, (short)5);
  private static final org.apache.thrift.protocol.TField THRIFT_MESSAGE_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("thriftMessageMap", org.apache.thrift.protocol.TType.MAP, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ThriftMessageStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ThriftMessageTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable String str; // required
  public int integer; // optional
  public double dou; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<String> stringList; // required
  public @org.apache.thrift.annotation.Nullable java.util.Set<ThriftMessage> thriftMessageSet; // required
  public @org.apache.thrift.annotation.Nullable java.util.Map<String,ThriftMessage> thriftMessageMap; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STR((short)1, "str"),
    INTEGER((short)2, "integer"),
    DOU((short)3, "dou"),
    STRING_LIST((short)4, "stringList"),
    THRIFT_MESSAGE_SET((short)5, "thriftMessageSet"),
    THRIFT_MESSAGE_MAP((short)6, "thriftMessageMap");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STR
          return STR;
        case 2: // INTEGER
          return INTEGER;
        case 3: // DOU
          return DOU;
        case 4: // STRING_LIST
          return STRING_LIST;
        case 5: // THRIFT_MESSAGE_SET
          return THRIFT_MESSAGE_SET;
        case 6: // THRIFT_MESSAGE_MAP
          return THRIFT_MESSAGE_MAP;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __INTEGER_ISSET_ID = 0;
  private static final int __DOU_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.INTEGER};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STR, new org.apache.thrift.meta_data.FieldMetaData("str", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INTEGER, new org.apache.thrift.meta_data.FieldMetaData("integer", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DOU, new org.apache.thrift.meta_data.FieldMetaData("dou", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STRING_LIST, new org.apache.thrift.meta_data.FieldMetaData("stringList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.THRIFT_MESSAGE_SET, new org.apache.thrift.meta_data.FieldMetaData("thriftMessageSet", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "ThriftMessage"))));
    tmpMap.put(_Fields.THRIFT_MESSAGE_MAP, new org.apache.thrift.meta_data.FieldMetaData("thriftMessageMap", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "ThriftMessage"))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftMessage.class, metaDataMap);
  }

  public ThriftMessage() {
    this.integer = 10;

  }

  public ThriftMessage(
    String str,
    double dou,
    java.util.List<String> stringList,
    java.util.Set<ThriftMessage> thriftMessageSet,
    java.util.Map<String,ThriftMessage> thriftMessageMap)
  {
    this();
    this.str = str;
    this.dou = dou;
    setDouIsSet(true);
    this.stringList = stringList;
    this.thriftMessageSet = thriftMessageSet;
    this.thriftMessageMap = thriftMessageMap;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftMessage(ThriftMessage other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetStr()) {
      this.str = other.str;
    }
    this.integer = other.integer;
    this.dou = other.dou;
    if (other.isSetStringList()) {
      java.util.List<String> __this__stringList = new java.util.ArrayList<String>(other.stringList);
      this.stringList = __this__stringList;
    }
    if (other.isSetThriftMessageSet()) {
      java.util.Set<ThriftMessage> __this__thriftMessageSet = new java.util.HashSet<ThriftMessage>(other.thriftMessageSet.size());
      for (ThriftMessage other_element : other.thriftMessageSet) {
        __this__thriftMessageSet.add(new ThriftMessage(other_element));
      }
      this.thriftMessageSet = __this__thriftMessageSet;
    }
    if (other.isSetThriftMessageMap()) {
      java.util.Map<String,ThriftMessage> __this__thriftMessageMap = new java.util.HashMap<String,ThriftMessage>(other.thriftMessageMap.size());
      for (java.util.Map.Entry<String, ThriftMessage> other_element : other.thriftMessageMap.entrySet()) {

        String other_element_key = other_element.getKey();
        ThriftMessage other_element_value = other_element.getValue();

        String __this__thriftMessageMap_copy_key = other_element_key;

        ThriftMessage __this__thriftMessageMap_copy_value = new ThriftMessage(other_element_value);

        __this__thriftMessageMap.put(__this__thriftMessageMap_copy_key, __this__thriftMessageMap_copy_value);
      }
      this.thriftMessageMap = __this__thriftMessageMap;
    }
  }

  public ThriftMessage deepCopy() {
    return new ThriftMessage(this);
  }

  @Override
  public void clear() {
    this.str = null;
    this.integer = 10;

    setDouIsSet(false);
    this.dou = 0.0;
    this.stringList = null;
    this.thriftMessageSet = null;
    this.thriftMessageMap = null;
  }

  @org.apache.thrift.annotation.Nullable
  public String getStr() {
    return this.str;
  }

  public ThriftMessage setStr(@org.apache.thrift.annotation.Nullable String str) {
    this.str = str;
    return this;
  }

  public void unsetStr() {
    this.str = null;
  }

  /** Returns true if field str is set (has been assigned a value) and false otherwise */
  public boolean isSetStr() {
    return this.str != null;
  }

  public void setStrIsSet(boolean value) {
    if (!value) {
      this.str = null;
    }
  }

  public int getInteger() {
    return this.integer;
  }

  public ThriftMessage setInteger(int integer) {
    this.integer = integer;
    setIntegerIsSet(true);
    return this;
  }

  public void unsetInteger() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __INTEGER_ISSET_ID);
  }

  /** Returns true if field integer is set (has been assigned a value) and false otherwise */
  public boolean isSetInteger() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __INTEGER_ISSET_ID);
  }

  public void setIntegerIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __INTEGER_ISSET_ID, value);
  }

  public double getDou() {
    return this.dou;
  }

  public ThriftMessage setDou(double dou) {
    this.dou = dou;
    setDouIsSet(true);
    return this;
  }

  public void unsetDou() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DOU_ISSET_ID);
  }

  /** Returns true if field dou is set (has been assigned a value) and false otherwise */
  public boolean isSetDou() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DOU_ISSET_ID);
  }

  public void setDouIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DOU_ISSET_ID, value);
  }

  public int getStringListSize() {
    return (this.stringList == null) ? 0 : this.stringList.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<String> getStringListIterator() {
    return (this.stringList == null) ? null : this.stringList.iterator();
  }

  public void addToStringList(String elem) {
    if (this.stringList == null) {
      this.stringList = new java.util.ArrayList<String>();
    }
    this.stringList.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<String> getStringList() {
    return this.stringList;
  }

  public ThriftMessage setStringList(@org.apache.thrift.annotation.Nullable java.util.List<String> stringList) {
    this.stringList = stringList;
    return this;
  }

  public void unsetStringList() {
    this.stringList = null;
  }

  /** Returns true if field stringList is set (has been assigned a value) and false otherwise */
  public boolean isSetStringList() {
    return this.stringList != null;
  }

  public void setStringListIsSet(boolean value) {
    if (!value) {
      this.stringList = null;
    }
  }

  public int getThriftMessageSetSize() {
    return (this.thriftMessageSet == null) ? 0 : this.thriftMessageSet.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<ThriftMessage> getThriftMessageSetIterator() {
    return (this.thriftMessageSet == null) ? null : this.thriftMessageSet.iterator();
  }

  public void addToThriftMessageSet(ThriftMessage elem) {
    if (this.thriftMessageSet == null) {
      this.thriftMessageSet = new java.util.HashSet<ThriftMessage>();
    }
    this.thriftMessageSet.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Set<ThriftMessage> getThriftMessageSet() {
    return this.thriftMessageSet;
  }

  public ThriftMessage setThriftMessageSet(@org.apache.thrift.annotation.Nullable java.util.Set<ThriftMessage> thriftMessageSet) {
    this.thriftMessageSet = thriftMessageSet;
    return this;
  }

  public void unsetThriftMessageSet() {
    this.thriftMessageSet = null;
  }

  /** Returns true if field thriftMessageSet is set (has been assigned a value) and false otherwise */
  public boolean isSetThriftMessageSet() {
    return this.thriftMessageSet != null;
  }

  public void setThriftMessageSetIsSet(boolean value) {
    if (!value) {
      this.thriftMessageSet = null;
    }
  }

  public int getThriftMessageMapSize() {
    return (this.thriftMessageMap == null) ? 0 : this.thriftMessageMap.size();
  }

  public void putToThriftMessageMap(String key, ThriftMessage val) {
    if (this.thriftMessageMap == null) {
      this.thriftMessageMap = new java.util.HashMap<String,ThriftMessage>();
    }
    this.thriftMessageMap.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<String,ThriftMessage> getThriftMessageMap() {
    return this.thriftMessageMap;
  }

  public ThriftMessage setThriftMessageMap(@org.apache.thrift.annotation.Nullable java.util.Map<String,ThriftMessage> thriftMessageMap) {
    this.thriftMessageMap = thriftMessageMap;
    return this;
  }

  public void unsetThriftMessageMap() {
    this.thriftMessageMap = null;
  }

  /** Returns true if field thriftMessageMap is set (has been assigned a value) and false otherwise */
  public boolean isSetThriftMessageMap() {
    return this.thriftMessageMap != null;
  }

  public void setThriftMessageMapIsSet(boolean value) {
    if (!value) {
      this.thriftMessageMap = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case STR:
      if (value == null) {
        unsetStr();
      } else {
        setStr((String)value);
      }
      break;

    case INTEGER:
      if (value == null) {
        unsetInteger();
      } else {
        setInteger((Integer)value);
      }
      break;

    case DOU:
      if (value == null) {
        unsetDou();
      } else {
        setDou((Double)value);
      }
      break;

    case STRING_LIST:
      if (value == null) {
        unsetStringList();
      } else {
        setStringList((java.util.List<String>)value);
      }
      break;

    case THRIFT_MESSAGE_SET:
      if (value == null) {
        unsetThriftMessageSet();
      } else {
        setThriftMessageSet((java.util.Set<ThriftMessage>)value);
      }
      break;

    case THRIFT_MESSAGE_MAP:
      if (value == null) {
        unsetThriftMessageMap();
      } else {
        setThriftMessageMap((java.util.Map<String,ThriftMessage>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STR:
      return getStr();

    case INTEGER:
      return getInteger();

    case DOU:
      return getDou();

    case STRING_LIST:
      return getStringList();

    case THRIFT_MESSAGE_SET:
      return getThriftMessageSet();

    case THRIFT_MESSAGE_MAP:
      return getThriftMessageMap();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STR:
      return isSetStr();
    case INTEGER:
      return isSetInteger();
    case DOU:
      return isSetDou();
    case STRING_LIST:
      return isSetStringList();
    case THRIFT_MESSAGE_SET:
      return isSetThriftMessageSet();
    case THRIFT_MESSAGE_MAP:
      return isSetThriftMessageMap();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftMessage)
      return this.equals((ThriftMessage)that);
    return false;
  }

  public boolean equals(ThriftMessage that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_str = true && this.isSetStr();
    boolean that_present_str = true && that.isSetStr();
    if (this_present_str || that_present_str) {
      if (!(this_present_str && that_present_str))
        return false;
      if (!this.str.equals(that.str))
        return false;
    }

    boolean this_present_integer = true && this.isSetInteger();
    boolean that_present_integer = true && that.isSetInteger();
    if (this_present_integer || that_present_integer) {
      if (!(this_present_integer && that_present_integer))
        return false;
      if (this.integer != that.integer)
        return false;
    }

    boolean this_present_dou = true;
    boolean that_present_dou = true;
    if (this_present_dou || that_present_dou) {
      if (!(this_present_dou && that_present_dou))
        return false;
      if (this.dou != that.dou)
        return false;
    }

    boolean this_present_stringList = true && this.isSetStringList();
    boolean that_present_stringList = true && that.isSetStringList();
    if (this_present_stringList || that_present_stringList) {
      if (!(this_present_stringList && that_present_stringList))
        return false;
      if (!this.stringList.equals(that.stringList))
        return false;
    }

    boolean this_present_thriftMessageSet = true && this.isSetThriftMessageSet();
    boolean that_present_thriftMessageSet = true && that.isSetThriftMessageSet();
    if (this_present_thriftMessageSet || that_present_thriftMessageSet) {
      if (!(this_present_thriftMessageSet && that_present_thriftMessageSet))
        return false;
      if (!this.thriftMessageSet.equals(that.thriftMessageSet))
        return false;
    }

    boolean this_present_thriftMessageMap = true && this.isSetThriftMessageMap();
    boolean that_present_thriftMessageMap = true && that.isSetThriftMessageMap();
    if (this_present_thriftMessageMap || that_present_thriftMessageMap) {
      if (!(this_present_thriftMessageMap && that_present_thriftMessageMap))
        return false;
      if (!this.thriftMessageMap.equals(that.thriftMessageMap))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStr()) ? 131071 : 524287);
    if (isSetStr())
      hashCode = hashCode * 8191 + str.hashCode();

    hashCode = hashCode * 8191 + ((isSetInteger()) ? 131071 : 524287);
    if (isSetInteger())
      hashCode = hashCode * 8191 + integer;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(dou);

    hashCode = hashCode * 8191 + ((isSetStringList()) ? 131071 : 524287);
    if (isSetStringList())
      hashCode = hashCode * 8191 + stringList.hashCode();

    hashCode = hashCode * 8191 + ((isSetThriftMessageSet()) ? 131071 : 524287);
    if (isSetThriftMessageSet())
      hashCode = hashCode * 8191 + thriftMessageSet.hashCode();

    hashCode = hashCode * 8191 + ((isSetThriftMessageMap()) ? 131071 : 524287);
    if (isSetThriftMessageMap())
      hashCode = hashCode * 8191 + thriftMessageMap.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ThriftMessage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStr()).compareTo(other.isSetStr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.str, other.str);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetInteger()).compareTo(other.isSetInteger());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInteger()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.integer, other.integer);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDou()).compareTo(other.isSetDou());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDou()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dou, other.dou);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStringList()).compareTo(other.isSetStringList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStringList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stringList, other.stringList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetThriftMessageSet()).compareTo(other.isSetThriftMessageSet());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetThriftMessageSet()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.thriftMessageSet, other.thriftMessageSet);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetThriftMessageMap()).compareTo(other.isSetThriftMessageMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetThriftMessageMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.thriftMessageMap, other.thriftMessageMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftMessage(");
    boolean first = true;

    sb.append("str:");
    if (this.str == null) {
      sb.append("null");
    } else {
      sb.append(this.str);
    }
    first = false;
    if (isSetInteger()) {
      if (!first) sb.append(", ");
      sb.append("integer:");
      sb.append(this.integer);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("dou:");
    sb.append(this.dou);
    first = false;
    if (!first) sb.append(", ");
    sb.append("stringList:");
    if (this.stringList == null) {
      sb.append("null");
    } else {
      sb.append(this.stringList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("thriftMessageSet:");
    if (this.thriftMessageSet == null) {
      sb.append("null");
    } else {
      sb.append(this.thriftMessageSet);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("thriftMessageMap:");
    if (this.thriftMessageMap == null) {
      sb.append("null");
    } else {
      sb.append(this.thriftMessageMap);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (str == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'str' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftMessageStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ThriftMessageStandardScheme getScheme() {
      return new ThriftMessageStandardScheme();
    }
  }

  private static class ThriftMessageStandardScheme extends org.apache.thrift.scheme.StandardScheme<ThriftMessage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.str = iprot.readString();
              struct.setStrIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INTEGER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.integer = iprot.readI32();
              struct.setIntegerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DOU
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.dou = iprot.readDouble();
              struct.setDouIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STRING_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.stringList = new java.util.ArrayList<String>(_list0.size);
                @org.apache.thrift.annotation.Nullable String _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readString();
                  struct.stringList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setStringListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // THRIFT_MESSAGE_SET
            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
              {
                org.apache.thrift.protocol.TSet _set3 = iprot.readSetBegin();
                struct.thriftMessageSet = new java.util.HashSet<ThriftMessage>(2*_set3.size);
                @org.apache.thrift.annotation.Nullable ThriftMessage _elem4;
                for (int _i5 = 0; _i5 < _set3.size; ++_i5)
                {
                  _elem4 = new ThriftMessage();
                  _elem4.read(iprot);
                  struct.thriftMessageSet.add(_elem4);
                }
                iprot.readSetEnd();
              }
              struct.setThriftMessageSetIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // THRIFT_MESSAGE_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map6 = iprot.readMapBegin();
                struct.thriftMessageMap = new java.util.HashMap<String,ThriftMessage>(2*_map6.size);
                @org.apache.thrift.annotation.Nullable String _key7;
                @org.apache.thrift.annotation.Nullable ThriftMessage _val8;
                for (int _i9 = 0; _i9 < _map6.size; ++_i9)
                {
                  _key7 = iprot.readString();
                  _val8 = new ThriftMessage();
                  _val8.read(iprot);
                  struct.thriftMessageMap.put(_key7, _val8);
                }
                iprot.readMapEnd();
              }
              struct.setThriftMessageMapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftMessage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.str != null) {
        oprot.writeFieldBegin(STR_FIELD_DESC);
        oprot.writeString(struct.str);
        oprot.writeFieldEnd();
      }
      if (struct.isSetInteger()) {
        oprot.writeFieldBegin(INTEGER_FIELD_DESC);
        oprot.writeI32(struct.integer);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(DOU_FIELD_DESC);
      oprot.writeDouble(struct.dou);
      oprot.writeFieldEnd();
      if (struct.stringList != null) {
        oprot.writeFieldBegin(STRING_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.stringList.size()));
          for (String _iter10 : struct.stringList)
          {
            oprot.writeString(_iter10);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.thriftMessageSet != null) {
        oprot.writeFieldBegin(THRIFT_MESSAGE_SET_FIELD_DESC);
        {
          oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, struct.thriftMessageSet.size()));
          for (ThriftMessage _iter11 : struct.thriftMessageSet)
          {
            _iter11.write(oprot);
          }
          oprot.writeSetEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.thriftMessageMap != null) {
        oprot.writeFieldBegin(THRIFT_MESSAGE_MAP_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, struct.thriftMessageMap.size()));
          for (java.util.Map.Entry<String, ThriftMessage> _iter12 : struct.thriftMessageMap.entrySet())
          {
            oprot.writeString(_iter12.getKey());
            _iter12.getValue().write(oprot);
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftMessageTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ThriftMessageTupleScheme getScheme() {
      return new ThriftMessageTupleScheme();
    }
  }

  private static class ThriftMessageTupleScheme extends org.apache.thrift.scheme.TupleScheme<ThriftMessage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.str);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetInteger()) {
        optionals.set(0);
      }
      if (struct.isSetDou()) {
        optionals.set(1);
      }
      if (struct.isSetStringList()) {
        optionals.set(2);
      }
      if (struct.isSetThriftMessageSet()) {
        optionals.set(3);
      }
      if (struct.isSetThriftMessageMap()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetInteger()) {
        oprot.writeI32(struct.integer);
      }
      if (struct.isSetDou()) {
        oprot.writeDouble(struct.dou);
      }
      if (struct.isSetStringList()) {
        {
          oprot.writeI32(struct.stringList.size());
          for (String _iter13 : struct.stringList)
          {
            oprot.writeString(_iter13);
          }
        }
      }
      if (struct.isSetThriftMessageSet()) {
        {
          oprot.writeI32(struct.thriftMessageSet.size());
          for (ThriftMessage _iter14 : struct.thriftMessageSet)
          {
            _iter14.write(oprot);
          }
        }
      }
      if (struct.isSetThriftMessageMap()) {
        {
          oprot.writeI32(struct.thriftMessageMap.size());
          for (java.util.Map.Entry<String, ThriftMessage> _iter15 : struct.thriftMessageMap.entrySet())
          {
            oprot.writeString(_iter15.getKey());
            _iter15.getValue().write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.str = iprot.readString();
      struct.setStrIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.integer = iprot.readI32();
        struct.setIntegerIsSet(true);
      }
      if (incoming.get(1)) {
        struct.dou = iprot.readDouble();
        struct.setDouIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list16 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.stringList = new java.util.ArrayList<String>(_list16.size);
          @org.apache.thrift.annotation.Nullable String _elem17;
          for (int _i18 = 0; _i18 < _list16.size; ++_i18)
          {
            _elem17 = iprot.readString();
            struct.stringList.add(_elem17);
          }
        }
        struct.setStringListIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TSet _set19 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.thriftMessageSet = new java.util.HashSet<ThriftMessage>(2*_set19.size);
          @org.apache.thrift.annotation.Nullable ThriftMessage _elem20;
          for (int _i21 = 0; _i21 < _set19.size; ++_i21)
          {
            _elem20 = new ThriftMessage();
            _elem20.read(iprot);
            struct.thriftMessageSet.add(_elem20);
          }
        }
        struct.setThriftMessageSetIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TMap _map22 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.thriftMessageMap = new java.util.HashMap<String,ThriftMessage>(2*_map22.size);
          @org.apache.thrift.annotation.Nullable String _key23;
          @org.apache.thrift.annotation.Nullable ThriftMessage _val24;
          for (int _i25 = 0; _i25 < _map22.size; ++_i25)
          {
            _key23 = iprot.readString();
            _val24 = new ThriftMessage();
            _val24.read(iprot);
            struct.thriftMessageMap.put(_key23, _val24);
          }
        }
        struct.setThriftMessageMapIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
