package app.tweditor;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericDocument extends PlainDocument {

    @Override
    public void insertString(int offset, String string, AttributeSet attributes)
            throws BadLocationException {
        if (string != null) {
            int stringLength = string.length();
            char initialChar;
            if (getLength() > 0) {
                initialChar = getText(0, 1).charAt(0);
            } else {
                initialChar = ' ';
            }
            switch (stringLength) {
                case 0:
                    super.insertString(offset, string, attributes);
                    break;
                case 1: {
                    char c = string.charAt(0);
                    if (Character.isDigit(c)) {
                        if ((offset != 0) || (initialChar != '-')) {
                            super.insertString(offset, string, attributes);
                        }
                    } else if ((c == '-')
                            && (offset == 0) && (initialChar != '-')) {
                        super.insertString(offset, string, attributes);
                    }
                }
                break;
                default:
                    StringBuilder buffer = new StringBuilder(string);
                    int index = 0;
                    while (index < stringLength) {
                        if ((offset == 0) && (index == 0)) {
                            char c = buffer.charAt(0);
                            if (Character.isDigit(c)) {
                                if (initialChar == '-') {
                                    buffer.deleteCharAt(index);
                                    stringLength--;
                                } else {
                                    index++;
                                }
                            } else if (c == '-') {
                                if (initialChar != '-') {
                                    index++;
                                } else {
                                    buffer.deleteCharAt(index);
                                    stringLength--;
                                }
                            } else {
                                buffer.deleteCharAt(index);
                                stringLength--;
                            }
                        } else if (Character.isDigit(buffer.charAt(index))) {
                            index++;
                        } else {
                            buffer.deleteCharAt(index);
                            stringLength--;
                        }

                    }
                    super.insertString(offset, buffer.toString(), attributes);
            }
        }
    }
}
