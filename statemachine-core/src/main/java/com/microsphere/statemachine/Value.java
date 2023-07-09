package com.microsphere.statemachine;


/**
 * #: todo - what is this
 *
 * @author wunhwantseng@gmail.com
 * @since todo - since from which version
 */
public interface Value {

    Object get();

    <T> T get(TypeSupplier<T> typeSupplier);

    @SuppressWarnings("unchecked")
   default <T> T get(Class<T> type){
       if (isInstanceOf(type)) {
           return (T) get();
       }

       // todo: wait to implement converter
       return null;
   }

    boolean isInstanceOf(Class<?> type);

    static Value of(Object value) {
        if (value == null){
            throw new IllegalArgumentException("value is required");
        }

        return new DefaultValue(value);
    }

    class DefaultValue implements Value {

        private final Object value;

        public DefaultValue(Object value) {
            this.value = value;
        }

        @Override
        public Object get() {
            return value;
        }

        @Override
        public <T> T get(TypeSupplier<T> typeSupplier) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isInstanceOf(Class<?> type) {
            return type.isInstance(value);
        }
    }

}
