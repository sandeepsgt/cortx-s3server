/*
 * COPYRIGHT 2019 SEAGATE LLC
 *
 * THIS DRAWING/DOCUMENT, ITS SPECIFICATIONS, AND THE DATA CONTAINED
 * HEREIN, ARE THE EXCLUSIVE PROPERTY OF SEAGATE TECHNOLOGY
 * LIMITED, ISSUED IN STRICT CONFIDENCE AND SHALL NOT, WITHOUT
 * THE PRIOR WRITTEN PERMISSION OF SEAGATE TECHNOLOGY LIMITED,
 * BE REPRODUCED, COPIED, OR DISCLOSED TO A THIRD PARTY, OR
 * USED FOR ANY PURPOSE WHATSOEVER, OR STORED IN A RETRIEVAL SYSTEM
 * EXCEPT AS ALLOWED BY THE TERMS OF SEAGATE LICENSES AND AGREEMENTS.
 *
 * YOU SHOULD HAVE RECEIVED A COPY OF SEAGATE'S LICENSE ALONG WITH
 * THIS RELEASE. IF NOT PLEASE CONTACT A SEAGATE REPRESENTATIVE
 * http://www.seagate.com/contact
 *
 * Original author:  Ajinkya Dhumal
 * Original creation date: 10-November-2019
 */

package com.seagates3.policy;

public
class S3ArnParser extends ArnParser {

 public
  S3ArnParser() {
    /**
     *  ARN format - arn:aws:s3:::<bucket_name>/<key_name>
     *  e.g. - arn:aws:s3:::seagatebucket/abc
     *       - arn:aws:s3:::seagatebucket/dir1/*
     *       - arn:aws:s3:::seagatebucket
     */
    this.regEx = "arn:aws:s3:::[a-zA-Z0-9~@#$^*\\\\/_.:-]+";
  }
}