// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc.proto

package br.com.cinema.server;

/**
 * Protobuf type {@code br.com.cinema.server.ChairList}
 */
public  final class ChairList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:br.com.cinema.server.ChairList)
    ChairListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChairList.newBuilder() to construct.
  private ChairList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChairList() {
    chairs_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ChairList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChairList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              chairs_ = new java.util.ArrayList<br.com.cinema.server.Chair>();
              mutable_bitField0_ |= 0x00000001;
            }
            chairs_.add(
                input.readMessage(br.com.cinema.server.Chair.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        chairs_ = java.util.Collections.unmodifiableList(chairs_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_ChairList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_ChairList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            br.com.cinema.server.ChairList.class, br.com.cinema.server.ChairList.Builder.class);
  }

  public static final int CHAIRS_FIELD_NUMBER = 1;
  private java.util.List<br.com.cinema.server.Chair> chairs_;
  /**
   * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
   */
  public java.util.List<br.com.cinema.server.Chair> getChairsList() {
    return chairs_;
  }
  /**
   * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
   */
  public java.util.List<? extends br.com.cinema.server.ChairOrBuilder> 
      getChairsOrBuilderList() {
    return chairs_;
  }
  /**
   * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
   */
  public int getChairsCount() {
    return chairs_.size();
  }
  /**
   * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
   */
  public br.com.cinema.server.Chair getChairs(int index) {
    return chairs_.get(index);
  }
  /**
   * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
   */
  public br.com.cinema.server.ChairOrBuilder getChairsOrBuilder(
      int index) {
    return chairs_.get(index);
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
    for (int i = 0; i < chairs_.size(); i++) {
      output.writeMessage(1, chairs_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < chairs_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, chairs_.get(i));
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
    if (!(obj instanceof br.com.cinema.server.ChairList)) {
      return super.equals(obj);
    }
    br.com.cinema.server.ChairList other = (br.com.cinema.server.ChairList) obj;

    if (!getChairsList()
        .equals(other.getChairsList())) return false;
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
    if (getChairsCount() > 0) {
      hash = (37 * hash) + CHAIRS_FIELD_NUMBER;
      hash = (53 * hash) + getChairsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static br.com.cinema.server.ChairList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.cinema.server.ChairList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.cinema.server.ChairList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.cinema.server.ChairList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.cinema.server.ChairList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static br.com.cinema.server.ChairList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static br.com.cinema.server.ChairList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.cinema.server.ChairList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.cinema.server.ChairList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static br.com.cinema.server.ChairList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static br.com.cinema.server.ChairList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static br.com.cinema.server.ChairList parseFrom(
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
  public static Builder newBuilder(br.com.cinema.server.ChairList prototype) {
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
   * Protobuf type {@code br.com.cinema.server.ChairList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:br.com.cinema.server.ChairList)
      br.com.cinema.server.ChairListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_ChairList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_ChairList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              br.com.cinema.server.ChairList.class, br.com.cinema.server.ChairList.Builder.class);
    }

    // Construct using br.com.cinema.server.ChairList.newBuilder()
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
        getChairsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (chairsBuilder_ == null) {
        chairs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        chairsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return br.com.cinema.server.GrpcProto.internal_static_br_com_cinema_server_ChairList_descriptor;
    }

    @java.lang.Override
    public br.com.cinema.server.ChairList getDefaultInstanceForType() {
      return br.com.cinema.server.ChairList.getDefaultInstance();
    }

    @java.lang.Override
    public br.com.cinema.server.ChairList build() {
      br.com.cinema.server.ChairList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public br.com.cinema.server.ChairList buildPartial() {
      br.com.cinema.server.ChairList result = new br.com.cinema.server.ChairList(this);
      int from_bitField0_ = bitField0_;
      if (chairsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          chairs_ = java.util.Collections.unmodifiableList(chairs_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.chairs_ = chairs_;
      } else {
        result.chairs_ = chairsBuilder_.build();
      }
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
      if (other instanceof br.com.cinema.server.ChairList) {
        return mergeFrom((br.com.cinema.server.ChairList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(br.com.cinema.server.ChairList other) {
      if (other == br.com.cinema.server.ChairList.getDefaultInstance()) return this;
      if (chairsBuilder_ == null) {
        if (!other.chairs_.isEmpty()) {
          if (chairs_.isEmpty()) {
            chairs_ = other.chairs_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureChairsIsMutable();
            chairs_.addAll(other.chairs_);
          }
          onChanged();
        }
      } else {
        if (!other.chairs_.isEmpty()) {
          if (chairsBuilder_.isEmpty()) {
            chairsBuilder_.dispose();
            chairsBuilder_ = null;
            chairs_ = other.chairs_;
            bitField0_ = (bitField0_ & ~0x00000001);
            chairsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getChairsFieldBuilder() : null;
          } else {
            chairsBuilder_.addAllMessages(other.chairs_);
          }
        }
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
      br.com.cinema.server.ChairList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (br.com.cinema.server.ChairList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<br.com.cinema.server.Chair> chairs_ =
      java.util.Collections.emptyList();
    private void ensureChairsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        chairs_ = new java.util.ArrayList<br.com.cinema.server.Chair>(chairs_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        br.com.cinema.server.Chair, br.com.cinema.server.Chair.Builder, br.com.cinema.server.ChairOrBuilder> chairsBuilder_;

    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public java.util.List<br.com.cinema.server.Chair> getChairsList() {
      if (chairsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(chairs_);
      } else {
        return chairsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public int getChairsCount() {
      if (chairsBuilder_ == null) {
        return chairs_.size();
      } else {
        return chairsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public br.com.cinema.server.Chair getChairs(int index) {
      if (chairsBuilder_ == null) {
        return chairs_.get(index);
      } else {
        return chairsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder setChairs(
        int index, br.com.cinema.server.Chair value) {
      if (chairsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChairsIsMutable();
        chairs_.set(index, value);
        onChanged();
      } else {
        chairsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder setChairs(
        int index, br.com.cinema.server.Chair.Builder builderForValue) {
      if (chairsBuilder_ == null) {
        ensureChairsIsMutable();
        chairs_.set(index, builderForValue.build());
        onChanged();
      } else {
        chairsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder addChairs(br.com.cinema.server.Chair value) {
      if (chairsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChairsIsMutable();
        chairs_.add(value);
        onChanged();
      } else {
        chairsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder addChairs(
        int index, br.com.cinema.server.Chair value) {
      if (chairsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChairsIsMutable();
        chairs_.add(index, value);
        onChanged();
      } else {
        chairsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder addChairs(
        br.com.cinema.server.Chair.Builder builderForValue) {
      if (chairsBuilder_ == null) {
        ensureChairsIsMutable();
        chairs_.add(builderForValue.build());
        onChanged();
      } else {
        chairsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder addChairs(
        int index, br.com.cinema.server.Chair.Builder builderForValue) {
      if (chairsBuilder_ == null) {
        ensureChairsIsMutable();
        chairs_.add(index, builderForValue.build());
        onChanged();
      } else {
        chairsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder addAllChairs(
        java.lang.Iterable<? extends br.com.cinema.server.Chair> values) {
      if (chairsBuilder_ == null) {
        ensureChairsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, chairs_);
        onChanged();
      } else {
        chairsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder clearChairs() {
      if (chairsBuilder_ == null) {
        chairs_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        chairsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public Builder removeChairs(int index) {
      if (chairsBuilder_ == null) {
        ensureChairsIsMutable();
        chairs_.remove(index);
        onChanged();
      } else {
        chairsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public br.com.cinema.server.Chair.Builder getChairsBuilder(
        int index) {
      return getChairsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public br.com.cinema.server.ChairOrBuilder getChairsOrBuilder(
        int index) {
      if (chairsBuilder_ == null) {
        return chairs_.get(index);  } else {
        return chairsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public java.util.List<? extends br.com.cinema.server.ChairOrBuilder> 
         getChairsOrBuilderList() {
      if (chairsBuilder_ != null) {
        return chairsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(chairs_);
      }
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public br.com.cinema.server.Chair.Builder addChairsBuilder() {
      return getChairsFieldBuilder().addBuilder(
          br.com.cinema.server.Chair.getDefaultInstance());
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public br.com.cinema.server.Chair.Builder addChairsBuilder(
        int index) {
      return getChairsFieldBuilder().addBuilder(
          index, br.com.cinema.server.Chair.getDefaultInstance());
    }
    /**
     * <code>repeated .br.com.cinema.server.Chair chairs = 1;</code>
     */
    public java.util.List<br.com.cinema.server.Chair.Builder> 
         getChairsBuilderList() {
      return getChairsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        br.com.cinema.server.Chair, br.com.cinema.server.Chair.Builder, br.com.cinema.server.ChairOrBuilder> 
        getChairsFieldBuilder() {
      if (chairsBuilder_ == null) {
        chairsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            br.com.cinema.server.Chair, br.com.cinema.server.Chair.Builder, br.com.cinema.server.ChairOrBuilder>(
                chairs_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        chairs_ = null;
      }
      return chairsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:br.com.cinema.server.ChairList)
  }

  // @@protoc_insertion_point(class_scope:br.com.cinema.server.ChairList)
  private static final br.com.cinema.server.ChairList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new br.com.cinema.server.ChairList();
  }

  public static br.com.cinema.server.ChairList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChairList>
      PARSER = new com.google.protobuf.AbstractParser<ChairList>() {
    @java.lang.Override
    public ChairList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChairList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChairList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChairList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public br.com.cinema.server.ChairList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

