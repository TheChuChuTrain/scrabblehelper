/*
 * WordToolsPanel.java
 *
 * Created on February 1, 2008, 8:18 AM
 */
package gui.mainwindow;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import scrabblehelper.StaticFields;
import scrabbletools.BruteAnagram;
import scrabbletools.Word;

/**
 *
 * @author  Nick
 */
public class WordToolsPanel extends javax.swing.JPanel {

    /** Creates new form WordToolsPanel */
    public WordToolsPanel() {
        initComponents();

        oldFieldBackground = lettersField.getBackground();
        oldButtonBackground = validWordLabel.getBackground();
        oldDisplayString = validWordLabel.getText();

        lettersField.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                checkWord();
            }

            public void removeUpdate(DocumentEvent e) {
                checkWord();
            }

            public void changedUpdate(DocumentEvent e) {
                checkWord();
            }
        });

        DocumentListener filterListener = new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                sortAndFilter();
            }

            public void removeUpdate(DocumentEvent e) {
                sortAndFilter();
            }

            public void changedUpdate(DocumentEvent e) {
                sortAndFilter();
            }
        };

        regexField.getDocument().addDocumentListener(filterListener);
        containsField.getDocument().addDocumentListener(filterListener);
        beginsWithField.getDocument().addDocumentListener(filterListener);
        endsWithField.getDocument().addDocumentListener(filterListener);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lettersField = new javax.swing.JTextField();
        wordLabel = new javax.swing.JLabel();
        isItAWordLabel = new javax.swing.JLabel();
        anagramLettersButton = new javax.swing.JButton();
        validWordLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        wordList = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sortTypeComboBox = new javax.swing.JComboBox();
        ascendingSortRadioButton = new javax.swing.JRadioButton();
        descendingSortRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        regexField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        containsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        beginsWithField = new javax.swing.JTextField();
        endsWithField = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dictionary"));

        lettersField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lettersFieldActionPerformed(evt);
            }
        });
        lettersField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lettersFieldFocusGained(evt);
            }
        });
        lettersField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lettersFieldInputMethodTextChanged(evt);
            }
        });
        lettersField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lettersFieldKeyTyped(evt);
            }
        });

        anagramLettersButton.setText("Anagram Letters!");
        anagramLettersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anagramLettersButtonActionPerformed(evt);
            }
        });

        validWordLabel.setFont(new java.awt.Font("Tahoma", 0, 15));
        validWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        validWordLabel.setText("Valid Word?");
        validWordLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        validWordLabel.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(wordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isItAWordLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lettersField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validWordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anagramLettersButton)
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lettersField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validWordLabel)
                    .addComponent(anagramLettersButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordLabel)
                    .addComponent(isItAWordLabel)))
        );

        wordList.setModel(new WordListModel());
        wordList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(wordList);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sort Options"));

        jLabel1.setText("Sort by:    ");

        sortTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Score", "Word Length" }));
        sortTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortTypeComboBoxActionPerformed(evt);
            }
        });

        orderButtonGroup.add(ascendingSortRadioButton);
        ascendingSortRadioButton.setText("Ascending");
        ascendingSortRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ascendingSortRadioButtonItemStateChanged(evt);
            }
        });
        ascendingSortRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascendingSortRadioButtonActionPerformed(evt);
            }
        });

        orderButtonGroup.add(descendingSortRadioButton);
        descendingSortRadioButton.setSelected(true);
        descendingSortRadioButton.setText("Descending");
        descendingSortRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                descendingSortRadioButtonStateChanged(evt);
            }
        });
        descendingSortRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                descendingSortRadioButtonItemStateChanged(evt);
            }
        });
        descendingSortRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descendingSortRadioButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Order:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(descendingSortRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ascendingSortRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addComponent(sortTypeComboBox, 0, 196, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sortTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ascendingSortRadioButton)
                    .addComponent(descendingSortRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Word Filters"));

        jLabel3.setText("Regular Expression:");

        regexField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                regexFieldInputMethodTextChanged(evt);
            }
        });

        jLabel4.setText("Words Contain:");

        jLabel5.setText("...begin with:");

        jLabel6.setText("...end with:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(regexField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(containsField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(beginsWithField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(endsWithField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(regexField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(containsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(beginsWithField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(endsWithField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void anagramLettersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anagramLettersButtonActionPerformed
        anagramLetters();
}//GEN-LAST:event_anagramLettersButtonActionPerformed

    private void ascendingSortRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascendingSortRadioButtonActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_ascendingSortRadioButtonActionPerformed

    private void lettersFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lettersFieldFocusGained
    //resetCheckWordColors();
    }//GEN-LAST:event_lettersFieldFocusGained

    private void lettersFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lettersFieldInputMethodTextChanged
       
    }//GEN-LAST:event_lettersFieldInputMethodTextChanged

    private void lettersFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lettersFieldKeyTyped

    }//GEN-LAST:event_lettersFieldKeyTyped

    private void lettersFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lettersFieldActionPerformed
        anagramLetters();
    }//GEN-LAST:event_lettersFieldActionPerformed

    private void sortTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortTypeComboBoxActionPerformed
        sortAndFilter();
    }//GEN-LAST:event_sortTypeComboBoxActionPerformed

    private void descendingSortRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_descendingSortRadioButtonStateChanged
        
    }//GEN-LAST:event_descendingSortRadioButtonStateChanged

    private void descendingSortRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descendingSortRadioButtonActionPerformed
        
    }//GEN-LAST:event_descendingSortRadioButtonActionPerformed

    private void descendingSortRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_descendingSortRadioButtonItemStateChanged
        sortAndFilter();
    }//GEN-LAST:event_descendingSortRadioButtonItemStateChanged

    private void regexFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_regexFieldInputMethodTextChanged
        System.out.println("Text enter");
    }//GEN-LAST:event_regexFieldInputMethodTextChanged

    private void ascendingSortRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ascendingSortRadioButtonItemStateChanged
        sortAndFilter();
    }//GEN-LAST:event_ascendingSortRadioButtonItemStateChanged

    public void sortAndFilter() {
        WordListModel wlm = (WordListModel) wordList.getModel();
        wlm.filter();
    }

    public void resetCheckWordColors() {
        lettersField.setBackground(oldFieldBackground);
        validWordLabel.setText(oldDisplayString);
        validWordLabel.setBackground(oldButtonBackground);
    }

    public void checkWord() {
        String letters = lettersField.getText();
        boolean isLetter = StaticFields.getDictionary().isWord(letters.toCharArray());

        Color newFieldBackground;
        String newDisplayString;
        Color newButtonBackground;
        if (isLetter) {
            newFieldBackground = new Color(0, 255, 0, 255);
            newDisplayString = "Valid Word";
            newButtonBackground = new Color(0, 255, 0, 255);
        } else {
            newFieldBackground = new Color(255, 0, 0, 255);
            newDisplayString = "Invalid Word";
            newButtonBackground = new Color(255, 0, 0, 255);
        }

        lettersField.setBackground(newFieldBackground);
        validWordLabel.setText(newDisplayString);
        validWordLabel.setBackground(newButtonBackground);

        lettersField.repaint();
        validWordLabel.repaint();
    }

    private void anagramLetters() {
        BruteAnagram anagram = new BruteAnagram(StaticFields.getDictionary());
        List<Word> words = anagram.getAnagramWords(lettersField.getText());
        setListWords(words);
    }

    private void clearList() {

    }

    private void setListWords(List<Word> words) {
        WordListModel m = (WordListModel) wordList.getModel();
        m.setWords(words);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anagramLettersButton;
    private javax.swing.JRadioButton ascendingSortRadioButton;
    private javax.swing.JTextField beginsWithField;
    private javax.swing.JTextField containsField;
    private javax.swing.JRadioButton descendingSortRadioButton;
    private javax.swing.JTextField endsWithField;
    private javax.swing.JLabel isItAWordLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lettersField;
    private javax.swing.ButtonGroup orderButtonGroup;
    private javax.swing.JTextField regexField;
    private javax.swing.JComboBox sortTypeComboBox;
    private javax.swing.JLabel validWordLabel;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JList wordList;
    // End of variables declaration//GEN-END:variables
    private class WordListModel implements ListModel {

        private Comparator<Word> sorter;
        private List<Word> words = new ArrayList<Word>();
        List<Integer> validInts = new ArrayList<Integer>();
        List<ListDataListener> ldls = new ArrayList<ListDataListener>();

        public WordListModel() {
        }

        public void filter() {
            validInts.clear();

            Collections.sort(words, getSortComparator());

            try {
                Pattern p = Pattern.compile(regexField.getText().toLowerCase(), Pattern.CASE_INSENSITIVE);

                String beginsWith = beginsWithField.getText().toLowerCase();
                String endsWith = endsWithField.getText().toLowerCase();
                String contains = containsField.getText().toLowerCase();

                for (int i = 0; i < words.size(); i++) {
                    Word w = words.get(i);
                    String s = w.getWordString().toLowerCase();
                    boolean display =
                            s.startsWith(beginsWith) &&
                            s.endsWith(endsWith) &&
                            s.contains(contains) &&
                            p.matcher(s).find();
                    if (display) {
                        validInts.add(i);
                    }
                }
            } catch (PatternSyntaxException ex) {
            }
            fireContentsChanged();
        }

        public Comparator<Word> getSortComparator() {
            final boolean sortAscending = ascendingSortRadioButton.isSelected();
            final int sortType = sortTypeComboBox.getSelectedIndex();
            //0 == Score
            //1 == Length

            Comparator<Word> scoreSorter = new Comparator<Word>() {

                public int compare(Word o1, Word o2) {
                    Integer score1 = o1.getScore();
                    Integer score2 = o2.getScore();

                    int result = score1.compareTo(score2);
                    if (!sortAscending) {
                        result = -result;
                    }
                    return result;
                }
            };

            Comparator<Word> lengthSorter = new Comparator<Word>() {

                public int compare(Word o1, Word o2) {
                    Integer len1 = o1.getWordString().length();
                    Integer len2 = o2.getWordString().length();

                    int result = len1.compareTo(len2);
                    if (!sortAscending) {
                        result = -result;
                    }
                    return result;
                }
            };

            if (sortType == 0) {
                return scoreSorter;
            } else {
                return lengthSorter;
            }
        }

        public int getSize() {
            return validInts.size();
        }

        public Object getElementAt(int index) {
            return getWords().get(validInts.get(index));
        }

        public void addListDataListener(ListDataListener l) {
            ldls.add(l);
        }

        public void removeListDataListener(ListDataListener l) {
            ldls.remove(l);
        }

        public List<Word> getWords() {
            return words;
        }

        public void setWords(List<Word> words) {
            this.words = words;
            filter();
        }

        public void fireContentsChanged() {
            for (ListDataListener l : ldls) {
                l.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, getSize()));
            }
        }
    }
    final Color oldFieldBackground;
    final Color oldButtonBackground;
    final String oldDisplayString;
}
