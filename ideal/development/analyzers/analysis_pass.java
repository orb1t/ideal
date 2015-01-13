/*
 * Copyright 2014 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.development.analyzers;

import ideal.library.elements.*;
import ideal.runtime.elements.*;

// TODO(m): make identifier
// TODO(m): has strong ordering
public enum analysis_pass implements deeply_immutable_data, stringable {

  BEFORE_EVALUATION,
  TYPE_DECL,
  IMPORT_AND_TYPE_VAR_DECL,
  SUPERTYPE_DECL,
  METHOD_AND_VARIABLE_DECL,
  BODY_CHECK;

  public boolean is_before(analysis_pass other) {
    return this.ordinal() < other.ordinal();
  }

  public boolean is_after(analysis_pass other) {
    return this.ordinal() > other.ordinal();
  }

  public static analysis_pass last() {
    return values()[values().length - 1];
  }

  @Override
  public string to_string() {
    return new base_string(name(), "/", String.valueOf(ordinal()));
  }
}
