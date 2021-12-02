// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc.proto

package br.com.cinema.server;

/**
 * Protobuf type {@code br.com.cinema.server.Chair}
 */
public  final class Chair extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:br.com.cinema.server.Chair)
    ChairOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Chair.newBuilder() to construct.
  private Chair(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Chair() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Chair();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Chair(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            number_ = input.readInt64();
            break;
          }
          case 16: {

            available_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_Chair_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_Chair_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.com.cinema.server.Chair.class, br.com.cinema.server.Chair.Builder.class);
  }

  public static final int NUMBER_FIELD_NUMBER = 1;
  private long number_;
  /**
   * <code>int64 number = 1;</code>
   * @return The number.
   */
  public long getNumber() {
    return number_;
  }

  public static final int AVAILABLE_FIELD_NUMBER = 2;
  private boolean available_;
  /**
   * <code>bool available = 2;</code>
   * @return The available.
   */
  public boolean getAvailable() {
    return available_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (number_ != 0L) {
      output.writeInt64(1, number_);
    }
    if (available_ != false) {
      output.writeBool(2, available_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (number_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, number_);
    }
    if (available_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, available_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof br.com.cinema.server.Chair)) {
      return super.equals(obj);
    }
    br.com.cinema.server.Chair other = (br.com.cinema.server.Chair) obj;

    if (getNumber()
        != other.getNumber()) return false;
    if (getAvailable()
        != other.getAvailable()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getNumber());
    hash = (37 * hash) + AVAILABLE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAvailable());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.com.cinema.server.Chair parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.cinema.server.Chair parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.cinema.server.Chair parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.cinema.server.Chair parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.cinema.server.Chair parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.cinema.server.Chair parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.cinema.server.Chair parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.cinema.server.Chair parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.cinema.server.Chair parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.com.cinema.server.Chair parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.cinema.server.Chair parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.cinema.server.Chair parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(br.com.cinema.server.Chair prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code br.com.cinema.server.Chair}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:br.com.cinema.server.Chair)
      br.com.cinema.server.ChairOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_Chair_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_Chair_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.com.cinema.server.Chair.class, br.com.cinema.server.Chair.Builder.class);
    }

    // Construct using br.com.cinema.server.Chair.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      number_ = 0L;

      available_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_Chair_descriptor;
    }

    @java.lang.Override
    public br.com.cinema.server.Chair getDefaultInstanceForType() {
      return br.com.cinema.server.Chair.getDefaultInstance();
    }

    @java.lang.Override
    public br.com.cinema.server.Chair build() {
      br.com.cinema.server.Chair result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public br.com.cinema.server.Chair buildPartial() {
      br.com.cinema.server.Chair result = new br.com.cinema.server.Chair(this);
      result.number_ = number_;
      result.available_ = available_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof br.com.cinema.server.Chair) {
        return mergeFrom((br.com.cinema.server.Chair)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.com.cinema.server.Chair other) {
      if (other == br.com.cinema.server.Chair.getDefaultInstance()) return this;
      if (other.getNumber() != 0L) {
        setNumber(other.getNumber());
      }
      if (other.getAvailable() != false) {
        setAvailable(other.getAvailable());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      br.com.cinema.server.Chair parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.com.cinema.server.Chair) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long number_ ;
    /**
     * <code>int64 number = 1;</code>
     * @return The number.
     */
    public long getNumber() {
      return number_;
    }
    /**
     * <code>int64 number = 1;</code>
     * @param value The number to set.
     * @return This builder for chaining.
     */
    public Builder setNumber(long value) {
      
      number_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumber() {
      
      number_ = 0L;
      onChanged();
      return this;
    }

    private boolean available_ ;
    /**
     * <code>bool available = 2;</code>
     * @return The available.
     */
    public boolean getAvailable() {
      return available_;
    }
    /**
     * <code>bool available = 2;</code>
     * @param value The available to set.
     * @return This builder for chaining.
     */
    public Builder setAvailable(boolean value) {
      
      available_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool available = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAvailable() {
      
      available_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:br.com.cinema.server.Chair)
  }

  // @@protoc_insertion_point(class_scope:br.com.cinema.server.Chair)
  private static final br.com.cinema.server.Chair DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.com.cinema.server.Chair();
  }

  public static br.com.cinema.server.Chair getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Chair>
      PARSER = new com.google.protobuf.AbstractParser<Chair>() {
    @java.lang.Override
    public Chair parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Chair(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Chair> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Chair> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public br.com.cinema.server.Chair getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

